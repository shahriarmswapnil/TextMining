import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class textMiningMain {

	public static void main(String[] args) throws IOException {
		// String fileDir="C:/Users/s4494660/Desktop/Litigation Releases";
		//String fileDir = "C:/Users/s4494660/Desktop/TXT";
		String fileDir = "C:/Users/s4494660/Desktop/TXT/testFiles";
		// String fileDir="C:/Users/s4494660/Google Drive/SEC Enforcement
		// Files/Litigation Releases/2010/TXT";

		File dir = new File(fileDir);

		String[] extensions = new String[] { "txt", "pdf" };

		System.out.println(
				"Getting all .txt and .pdf files in " + dir.getCanonicalPath() + " including those in subdirectories");

		List<File> files = (List<File>) FileUtils.listFiles(dir, extensions, true);
		textMining test;
		//FileWriter writer = new FileWriter("C:/Users/s4494660/Desktop/TXT/results.txt", true);
		for (File file : files) 
		{
			test = new textMining(file);

			String fileName = test.fileName();
			String companyName = test.companyName();
//			String defendantName = test.defendantName();
//			String position = test.positionCheck();
//			String caseType = test.caseType();
//			String chargeType = test.orderCheck();
//			String resolutionType = test.resolutionCheck();
//			String date = test.dateCheck();
//
			System.out.println("File Name: " + fileName);
//			System.out.println("Company Name: " + companyName);

//			System.out.println("Defendant Name: " + defendantName);
//			System.out.println("Position: " + position);
//			System.out.println("Case Type: " + caseType);
//			System.out.println("Charge Type: " + chargeType);
//			System.out.println("Resolution Type: " + resolutionType);
//			System.out.println("Date: " + date);

			System.out.println();

			//writer.append(fileName + ","+defendantName + ","+position + ","+companyName + ","+caseType + ","+chargeType + ","+resolutionType + ","+date);
			//writer.append("\n");

		}
		
	   // writer.flush();
	    //writer.close();
	

	}

}
