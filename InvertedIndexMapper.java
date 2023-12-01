/******************************************************************************************************************************************
 * Alina Zacaria, Student @ Loyola University Chicago
 * Contact: alinazac9@gmail.com
 * Date: November 17th, 2023
 * @version final
 ******************************************************************************************************************************************/

package org.alinazac;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import java.io.IOException;
import java.util.StringTokenizer;

/** Mapper class for the Inverted Index Program **/
public class InvertedIndexMapper extends Mapper<LongWritable, Text, Text, Text> {
    private Text word = new Text();
    private Text IDTF = new Text();

    /**
     * Mapper method to store the occurrences of the word in the document(s).
     * @param key                    The input key (position in the file) - LongWritable.
     * @param value                  The input value (a line of text) - Text.
     * @throws InterruptedException  Signals an interruption with the mapper.
     * @throws IOException           Signals that an I/O exception has occurred.
     */

    @Override
    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        // Convert the Text value to string
        String line = value.toString();

        // Tokenize the line for independent words and store them
        StringTokenizer tokenizer = new StringTokenizer(line);

        // Store the document ID by input split
        String documentID = context.getInputSplit().toString();

        // While there are more tokens in the tokenizer...
        while (tokenizer.hasMoreTokens()) {
            // Retrieve each token from the tokenizer
            String token = tokenizer.nextToken();
            // Clean the token to replace all non-alphanumeric characters and convert to lowercase
            token = token.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
            // Collect the token and set as the word
            word.set(token);
            // Set the default term frequency as one
            IntWritable termFrequency = new IntWritable(1);
            // Combine the indexed document frequency with the document ID and the term frequency
            IDTF.set(documentID + ":" + termFrequency);
            // Emit the word and indexed document frequency to the reducer
            context.write(word, IDTF);
        }
    }
}
