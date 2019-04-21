package dev.codenation.desafiocn;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class HTTPConnection {

	public static String get(String uri, String token) {
		StringBuilder build = new StringBuilder();
		try {

			URL url = new URL(uri + token);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			String output;

			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
				build.append(output);
			}

			conn.disconnect();

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return build.toString();
	}



	public static void post(String uri, String token, String file) throws Exception {

		URL url = new URL(uri + token);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();

		String boundaryString = "" + System.currentTimeMillis();
		File logFileToUpload = new File(file);

		// Indicate that we want to write to the HTTP request body
		conn.setDoOutput(true);
		conn.setRequestMethod("POST");
		conn.addRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundaryString);

		OutputStream outputStreamToRequestBody = conn.getOutputStream();
		BufferedWriter httpRequestBodyWriter =
		    new BufferedWriter(new OutputStreamWriter(outputStreamToRequestBody));

		// Include value from the myFileDescription text area in the post data
		httpRequestBodyWriter.write("\n\n--" + boundaryString + "\n");
		httpRequestBodyWriter.write("Content-Disposition: form-data; name=\"goreact\"");
		httpRequestBodyWriter.write("\n\n");
		//httpRequestBodyWriter.write("Log file for 20150208");

		// Include the section to describe the file
		httpRequestBodyWriter.write("\n--" + boundaryString + "\n");
		httpRequestBodyWriter.write("Content-Disposition: form-data;"
		        + "name=\"answer\";"
		        + "filename=\""+ logFileToUpload.getName() +"\""
		        + "\nContent-Type: text/plain\n\n");
		httpRequestBodyWriter.flush();

		// Write the actual file contents
		FileInputStream inputStreamToLogFile = new FileInputStream(logFileToUpload);

		int bytesRead;
		byte[] dataBuffer = new byte[1024];
		while((bytesRead = inputStreamToLogFile.read(dataBuffer)) != -1) {
		    outputStreamToRequestBody.write(dataBuffer, 0, bytesRead);
		}

		outputStreamToRequestBody.flush();

		// Mark the end of the multipart http request
		httpRequestBodyWriter.write("\n--" + boundaryString + "--\n");
		httpRequestBodyWriter.flush();
		
		System.err.println(conn.getResponseMessage());
		System.err.println(conn.getResponseCode());

		// Close the streams
		outputStreamToRequestBody.close();
		httpRequestBodyWriter.close();

	}

}
