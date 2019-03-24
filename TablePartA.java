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

public class TablePartA{

    public static void main(String[] args) throws IOException {

        //TODO
 
        Configuration con = HBaseConfiguration.create();
 
        HBaseAdmin admin = new HBaseAdmin(con);
 
        HTableDescriptor tableDescriptor = new HTableDescriptor(TableName.valueOf("powers"));
 
        tableDescriptor.addFamily(new HColumnDescriptor("personal"));
        tableDescriptor.addFamily(new HColumnDescriptor("professional"));
        tableDescriptor.addFamily(new HColumnDescriptor("custom"));
 
        admin.createTable(tableDescriptor);
 
        HTableDescriptor tableDes = new HTableDescriptor(TableName.valueOf("food"));
 
        tableDes.addFamily(new HColumnDescriptor("nutrition"));
        tableDes.addFamily(new HColumnDescriptor("taste"));
 
        admin.createTable(tableDes);
 
    }
}
