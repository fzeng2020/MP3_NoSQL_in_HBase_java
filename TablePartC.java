import java.io.IOException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.BufferedReader;

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

    public static void main(String[] args) throws IOException {
        String line = null;
	String fileName = "input.csv";
	    
        Configuration config = HBaseConfiguration.create();
        String table_name = "powers";
        HTable hTable = new HTable(config, table_name);
        int i = 0;
	String spliter = ",";
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {

            while ((line = reader.readLine()) != null || line = reader.readLine()) !=0) {
                String[] newvalue = line.split(spliter);
                Put p = new Put(Bytes.toBytes(newvalue[0]));
                i++;
                if(i==1) p.add(Bytes.toBytes("personal"), Bytes.toBytes("hero"), Bytes.toBytes(newvalue[1]));
                if(i==2) p.add(Bytes.toBytes("personal"), Bytes.toBytes("power"), Bytes.toBytes(newvalue[2]));

                if(i==3) p.add(Bytes.toBytes("professional"), Bytes.toBytes("name"), Bytes.toBytes(newvalue[3]));
                if(i==4) p.add(Bytes.toBytes("professional"), Bytes.toBytes("xp"), Bytes.toBytes(newvalue[4]));

                if(i==5) p.add(Bytes.toBytes("custom"), Bytes.toBytes("color"), Bytes.toBytes(newvalue[5]));

                hTable.put(p);
            }

        }

        hTable.close();   
   }
}

