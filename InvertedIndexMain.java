/******************************************************************************************************************************************
 * Alina Zacaria, Student @ Loyola University Chicago
 * Contact: alinazac9@gmail.com
 * Date: November 17th, 2023
 * @version final
 ******************************************************************************************************************************************/

package org.alinazac;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.*;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

/** Main class that executes and sets up an Inverted Index Program through MapReduce **/
public class InvertedIndexMain {

    /**
     * Main method to set up and execute the MapReduce job.
     * @param args          Input and output file paths as arguments.
     * @throws IOException  Signals that an I/O exception has occurred.
     */

    public static void main(String[] args) throws Exception {
        // Setting up the configuration for the MapReduce Job
        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf, "Inverted Index Performance Task");

        // Linking the Mapper, Reducer, and Combiner classes
        job.setJarByClass(InvertedIndexMain.class);
        job.setMapperClass(InvertedIndexMapper.class);
        job.setReducerClass(InvertedIndexReducer.class);

        // Setting the output key and values as the word and occurrence in all documents
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);

        // Storing the input path from the first argument
        FileInputFormat.addInputPath(job, new Path(args[0]));

        // Storing the output path from the first argument
        FileOutputFormat.setOutputPath(job, new Path(args[1]));

        // Successfully exiting
        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}
