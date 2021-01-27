package com.iae.utils

import org.apache.spark.sql.jdbc.JdbcDialect
import org.apache.spark.sql.jdbc.JdbcType
import org.apache.spark.sql.types.DataType
import org.apache.spark.sql.types.StringType
import org.apache.spark.sql.DataFrame
import java.sql.Types

class HiveDialect extends JdbcDialect { 
override def canHandle(url: String): Boolean = url.startsWith("jdbc:hive2")
   override def quoteIdentifier(colName: String): String = "`"+s"`$colName`".split("\\.")(1)
  override def getJDBCType(dt: DataType): Option[JdbcType] = dt match {
    case StringType => Option(JdbcType("STRING", Types.VARCHAR))
    case _ => None
  }
}
