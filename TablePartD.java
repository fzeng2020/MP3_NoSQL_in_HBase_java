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
	HTable table = new HTable(config, "powers");
	   
	//	Instantiating	Get	class
	Get g = new Get(Bytes.toBytes("row1"));
	//	Reading	the	data
	Result result = table.get(g);
	   
	//	Reading	values	from	Result	class	object
	byte [] value1 = result.getValue(Bytes.toBytes("personal"),Bytes.toBytes("hero"));
	byte []	value2 = result.getValue(Bytes.toBytes("personal"),Bytes.toBytes("power"));
	byte []	value3 = result.getValue(Bytes.toBytes("professional"),Bytes.toBytes("name"));  
	byte [] value4 = result.getValue(Bytes.toBytes("professional"),Bytes.toBytes("xp"));
	byte []	value5 = result.getValue(Bytes.toBytes("custom"),Bytes.toBytes("color"));
	
	   
	//	Printing	the	values
        String  hero = Bytes.toString(value1);
        String  power = Bytes.toString(value2);
        String  name = Bytes.toString(value3);
        String  xp = Bytes.toString(value4);
        String  color = Bytes.toString(value5);
	
 
	System.out.println("hero: "+hero+", power: "+power+", name: "+name+", xp: "+xp+", color: "+color);

	   
	Get y = new Get(Bytes.toBytes("row19"));
         //      Reading the     data
        Result  result19 =  table.get(y);
         //      Reading values  from    Result  class   object
        byte [] v1 = result19.getValue(Bytes.toBytes("personal"),Bytes.toBytes("hero"));
        byte [] v2 = result19.getValue(Bytes.toBytes("custom"),Bytes.toBytes("color"));  
	   
	String  hero19   =  Bytes.toString(v1);
	String  color19  =  Bytes.toString(v2);   
	   
	System.out.println("hero: "+hero19+", color: "+color19);
	
	   
	Get z = new Get(Bytes.toBytes("row1"));
	Result result1 = table.get(z);	   
	byte [] value11 = result1.getValue(Bytes.toBytes("personal"),Bytes.toBytes("hero"));
 
	byte []	value31 = result1.getValue(Bytes.toBytes("professional"),Bytes.toBytes("name"));  
	 
	byte []	value51 = result1.getValue(Bytes.toBytes("custom"),Bytes.toBytes("color"));
	

        String  hero1 = Bytes.toString(value11);
        String  name1 = Bytes.toString(value31); 
        String  color1 = Bytes.toString(value51);
	   
	   
	System.out.println("hero: "+hero1+", name: "+name1+", color: "+color1); 
   }
}

