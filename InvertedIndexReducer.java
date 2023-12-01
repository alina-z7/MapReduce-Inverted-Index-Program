/******************************************************************************************************************************************
 * Alina Zacaria, Student @ Loyola University Chicago
 * Contact: alinazac9@gmail.com
 * Date: November 17th, 2023
 * @version final
 ******************************************************************************************************************************************/

package org.alinazac;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/** Reducer class for the Inverted Index Program **/
public class InvertedIndexReducer extends Reducer<Text, Text, Text, Text> {
    private Text result = new Text();

    /**
     * Mapper method to store the occurrences of the word in the document(s).
     * @param key                    The input key (position in the file) - LongWritable.
     * @param values                 The input value (a line of text) - Text.
     * @param context                Object that writes to output by interacting with the MapReduce framework
     * @throws InterruptedException  Signals an interruption with the mapper.
     * @throws IOException           Signals that an I/O exception has occurred.
     */

    public void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        // A HashMap to store the document frequency
        Map<String, Integer> DFMap = new HashMap<>();

        // For every input value of the document names...
        for (Text value : values) {
            // Store the value in a variable
            String documentName = value.toString();
            // And set the document name as the key in the document frequency map and increment its count
            DFMap.put(documentName, DFMap.getOrDefault(documentName, 0) + 1);
        }

        // Prepare the output value by combining the (key) document name and its (value) occurrence
        StringBuilder outputValue = new StringBuilder();
        for (Map.Entry<String, Integer> keyValueEntry : DFMap.entrySet()) {
            outputValue.append(keyValueEntry.getKey()).append(":").append(keyValueEntry.getValue()).append(" ");
        }

        // Set the result with the inverted index calculation
        result.set(outputValue.toString());

        // Output the (key) word and its inverted index to context
        context.write(key, result);
    }
}
