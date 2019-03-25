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
	   
	      // Instantiating Configuration class
      Configuration config = HBaseConfiguration.create();

      // Instantiating HTable class
      HTable table = new HTable(config, "powers");	
  
      // Instantiating the Scan class
      Scan scan = new Scan();	 
  
	   
      scan.addColumn(Bytes.toBytes("personal"), Bytes.toBytes("hero"));
      scan.addColumn(Bytes.toBytes("personal"), Bytes.toBytes("power"));
      scan.addColumn(Bytes.toBytes("professional"), Bytes.toBytes("name"));
      scan.addColumn(Bytes.toBytes("professional"), Bytes.toBytes("xp"));
      scan.addColumn(Bytes.toBytes("custom"), Bytes.toBytes("color"));
	   
      ResultScanner scanner = table.getScanner(scan);
      List<MyData> tableData = new ArrayList<MyData>();

	// Reading values from scan result
      for (Result result = scanner.next(); result != null; result = scanner.next()){
		byte[] nameValue = result.getValue(Bytes.toBytes("professional"), Bytes.toBytes("name"));
		byte[] powerValue = result.getValue(Bytes.toBytes("personal"), Bytes.toBytes("power"));
		byte[] colorValue = result.getValue(Bytes.toBytes("custom"), Bytes.toBytes("color"));	  
	      
	      	leftTuple data  = new MyData(Bytes.toString(nameValue),Bytes.toString(powerValue),Bytes.toString(colorValue));
		leftTuple.add(data);	
	      
	      	rightTuple data = new MyData(Bytes.toString(nameValue),Bytes.toString(powerValue),Bytes.toString(colorValue));
		rightTuple.add(data);	
      }
 
      int leftTupleSize = leftTuple.size();
      int rightTupleSize = rightTuple.size();
		 
      for (int i = 0; i < leftTupleSize; i++){
		
	   Tuple left = leftTuple.get(i);
		  
	   for (int k = 0; k < rightTupleSize; k++){
		   Tuple right = rightTuple.get(k);
		   if(left.color.equals(right.color) && !left.name.equals(right.name)) {

	                    System.out.println(left.name + ", " + left.power + ", " + right.name + ", " + right.power + ", "+right.color);
			
		    }	    
				
	   }
       }	      
   }
}
