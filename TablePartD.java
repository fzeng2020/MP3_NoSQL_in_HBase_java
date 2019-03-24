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
import org.apache.hadoop.hbase.client.Get;


import org.apache.hadoop.hbase.util.Bytes;

public class TablePartD{

   public static void main(String[] args) throws IOException {

	// TODO      
	// DON' CHANGE THE 'System.out.println(xxx)' OUTPUT PART
	// OR YOU WON'T RECEIVE POINTS FROM THE GRADER 
	   
	//	Instantiating	Configuration	class
	Configuration config = HBaseConfiguration.create();
	   
	//	Instantiating	HTable	class
	HTable table = new HTable(config, "emp");
	//	Instantiating	Get	class
	Get g = new Get(Bytes.toBytes("row1"));
	//	Reading	the	data
	Result result = table.get(g);
	   
	//	Reading	values	from	Result	class	object
	byte []	value =	result.getValue(Bytes.toBytes("personal"),Bytes.toBytes("name"));
	byte []	value1 = result.getValue(Bytes.toBytes("personal"),Bytes.toBytes("city"));
	   
	//	Printing	the	values
	String name = Bytes.toString(value);
	String city = Bytes.toString(value1);	
	
	String hero = ???;
	String power = ???;
	String name = ???;
	String xp = ???;
	String color = ???;
	System.out.println("hero: "+hero+", power: "+power+", name: "+name+", xp: "+xp+", color: "+color);

	hero = ???;
	color = ???;
	System.out.println("hero: "+hero+", color: "+color);

	hero = ???;
	name = ???;
	color = ???;
	System.out.println("hero: "+hero+", name: "+name+", color: "+color); 
   }
}

