import java.io.IOException;

import org.apache.hadoop.conf.Configuration;

import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;

import org.apache.hadoop.hbase.TableName;

import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;

import org.apache.hadoop.hbase.util.Bytes;

public class TablePartE{

   public static void main(String[] args) throws IOException {

	// TODO      
	// DON' CHANGE THE 'System.out.println(xxx)' OUTPUT PART
	// OR YOU WON'T RECEIVE POINTS FROM THE GRADER
	   
//	Instantiating	Configuration	class
	Configuration	config	=	HBaseConfiguration.create();
	   
	String	tablename = "powers";				
	HTable	table	=	new	HTable(config,	tablename);
	Scan	scan	=	new	Scan();
						
	//scan.addColumn(Bytes.toBytes("personal"),	Bytes.toBytes("name"));
	//scan.addColumn(Bytes.toBytes("personal"),	Bytes.toBytes("city"));
						//	Getting	the	scan	result
	   
	   
	ResultScanner scanner = table.getScanner(scan);
	for (Result result = scanner.next(); result != null; result = scanner.next())
		System.out.println(result);
   }
}

