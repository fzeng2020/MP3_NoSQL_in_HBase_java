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

public class TablePartF{

   public static void main(String[] args) throws IOException {

	// TODO      
	// DON' CHANGE THE 'System.out.println(xxx)' OUTPUT PART
	// OR YOU WON'T RECEIVE POINTS FROM THE GRADER      
      scan.addColumn(Bytes.toBytes("personal"), Bytes.toBytes("hero"));
      scan.addColumn(Bytes.toBytes("personal"), Bytes.toBytes("power"));
      scan.addColumn(Bytes.toBytes("professional"), Bytes.toBytes("name"));
      scan.addColumn(Bytes.toBytes("professional"), Bytes.toBytes("xp"));
      scan.addColumn(Bytes.toBytes("custom"), Bytes.toBytes("color"));
	   
	   
  private Tuple joinTuples(Tuple leftTuple, Tuple rightTuple)
    {
		int leftTupleSize = leftTuple.getTupleDesc().numFields();
		int rightTupleSize = rightTuple.getTupleDesc().numFields();
		Tuple mergedTuple = new Tuple(this.getTupleDesc());
		for (int i = 0; i < leftTupleSize; i++)
		{
			mergedTuple.setField(i, leftTuple.getField(i));
		}
		for (int i = 0; i < rightTupleSize; i++)
		{
			mergedTuple.setField(leftTupleSize + i, rightTuple.getField(i));
		}
//		System.out.println("merged tuple: " + mergedTuple.toString());
		return mergedTuple;
	
	String name = ???;
	String power = ???;
	String color = ???;

	String name1 = ???;
	String power1 = ???;
	String color1 = ???;
	System.out.println(name + ", " + power + ", " + name1 + ", " + power1 + ", "+color);

   }
}
