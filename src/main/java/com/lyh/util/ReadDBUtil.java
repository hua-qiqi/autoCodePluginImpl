package com.lyh.util;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.zte.lyh.PluginParamsConfig;

public class ReadDBUtil {

	private static Connection connection = null;
	private static String driver = null;

	private static void initDB(PluginParamsConfig p) {
		driver = p.getDriver();
		String dbUrl = p.getUrl();
		String username = p.getUser();
		String password = p.getPassword();
		// 加载驱动
		try {
			Class.forName(driver);
			Properties props = new Properties();
			props.put("user", username);
			props.put("password", password);
			props.put("remarksReporting", "true");
			connection = DriverManager.getConnection(dbUrl, props);
			// 获得数据库连接
			// connection = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static Map<String, Map<String, String>> paraseDBInfo2Map(PluginParamsConfig p)
			throws SQLException, ClassNotFoundException {
		initDB(p);
		Map<String, Map<String, String>> tableNameMap = new HashMap<>();
		if (driver.toLowerCase().contains("sqlserver")) {
			tableNameMap = paraseSqlServer();
		} else {
			tableNameMap = paraseOtherDb();
		}
		return tableNameMap;

	}

	/**
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static Map<String, Map<String, String>> paraseOtherDb() throws SQLException, ClassNotFoundException {
		Map<String, Map<String, String>> maps = new HashMap<>();
		// 获得元数据
		DatabaseMetaData metaData = connection.getMetaData();
		// 获得表信息
		ResultSet tables = metaData.getTables(null, null, null, new String[] { "TABLE" });

		while (tables.next()) {
			// 获得表名
			String table_name = tables.getString("TABLE_NAME");
			// 通过表名获得所有字段名
			ResultSet columns = metaData.getColumns(null, null, table_name, "%");
			List<String> tableNames = new ArrayList<String>();
			Map<String, String> map = null;
			int count = 0;
			// 获得所有字段名
			while (columns.next()) {
				// 获得字段名
				String column_name = columns.getString("COLUMN_NAME");
				// 获得字段注释 注意： 对于此列，SQL Server 始终会返回 Null。
				String remarks = columns.getString("REMARKS");
				// https://docs.microsoft.com/zh-cn/sql/connect/jdbc/reference/getcolumns-method-sqlserverdatabasemetadata?view=sql-server-2017
				if (tableNames.contains(table_name)) {
					map.put(column_name.replaceAll("_", "").toLowerCase(), remarks);
				} else {
					if (count > 0) {
						maps.put(tableNames.get(tableNames.size() - 1), map);
					}

					maps.put(table_name, map);
					map = new HashMap<>();
					tableNames.add(table_name);
					map.put(column_name.replaceAll("_", "").toLowerCase(), remarks);
				}
				count++;
			}

		}

		return maps;
	}

	/**
	 * @return
	 * @throws SQLException
	 */
	public static Map<String, Map<String, String>> paraseSqlServer() throws SQLException {

		Map<String, Map<String, String>> columns = new HashMap<>(32);
		try {

			String sql = "SELECT     \r\n" + "t=cast(d.name as varchar(500)),   \r\n" +

					"  t1=cast(a.name as varchar(500)),   \r\n" +

					"  t2=isnull(cast(g.[value] as varchar(500)),'')   \r\n" + "  FROM   syscolumns   a   \r\n" +

					"  inner   join   sysobjects   d   on   a.id=d.id     and   d.xtype='U'   and     d.name<>'dtproperties'   \r\n"
					+

					"  left   join   sys.extended_properties g   on   a.id=g.major_id   and   a.colid=g.minor_id          \r\n";

			ResultSet rs = connection.createStatement().executeQuery(sql);

			String tableName = null;
			int count = 0;
			List<String> tableNames = new ArrayList<String>();
			Map<String, String> map = null;
			while (rs.next()) {
				tableName = rs.getString("t").replaceAll("_", "").toLowerCase();
				if (tableNames.contains(tableName)) {
					map.put(rs.getString("t1").replaceAll("_", "").toLowerCase(), rs.getString("t2"));
				} else {
					if (count > 0) {
						columns.put(tableNames.get(tableNames.size() - 1), map);
					}

					tableNames.add(tableName);
					map = new HashMap<>();
					map.put(rs.getString("t1").replaceAll("_", "").toLowerCase(), rs.getString("t2"));

				}
				count++;
			}
			columns.put(tableName, map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return columns;
	}


}
