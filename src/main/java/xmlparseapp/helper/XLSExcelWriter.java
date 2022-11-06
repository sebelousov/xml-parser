package xmlparseapp.helper;

import java.io.File;
import java.io.IOException;
import java.util.List;

import jxl.Workbook;
import jxl.format.Colour;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import xmlparseapp.entity.Job;

public class XLSExcelWriter implements ExcelWriter {

	@Override
	public void write(List<Job> jobs) {
		// TODO Auto-generated method stub
		if (jobs == null) {
			return;
		}
		
		File file = new File(".");
		String path = file.getAbsolutePath();
		String fileLocation = path.substring(0, path.length() - 1) + "temp.xls";
		
		String[] headers = {
				"Job",
				"Order",
				"Theme",
				"Author",
				"Title",
				"URL",
				"Date",
				"Content"
		};
		
		WritableWorkbook workbook = null;
		WritableSheet sheet = null;
		
		try {
			workbook = Workbook.createWorkbook(new File(fileLocation));
			sheet = workbook.createSheet("Test sheet", 0);
			
			WritableCellFormat formatHeader = new WritableCellFormat();
			WritableFont fontHeader = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD);
			
			formatHeader.setFont(fontHeader);
			formatHeader.setBackground(Colour.WHITE);
			formatHeader.setWrap(false);
			
			WritableCellFormat formatCell = new WritableCellFormat();
			WritableFont font = new WritableFont(WritableFont.ARIAL, 8, WritableFont.NO_BOLD);
			
			formatCell.setFont(font);
			formatCell.setBackground(Colour.WHITE);
			formatCell.setWrap(false);
			
			Label headerCell = null;
			
			for (int i = 0; i < headers.length; i++) {
				headerCell = new Label(i, 0, headers[i], formatCell);
				sheet.setColumnView(0, 20);
				sheet.addCell(headerCell);
			}
			
			Label cellText = null;
			for (int i = 0; i< jobs.size(); i++) {

				cellText = new Label(0, i + 1, jobs.get(i).getJobId(), formatCell);
				sheet.addCell(cellText);
				
				cellText = new Label(1, i + 1, jobs.get(i).getOrder(), formatCell);
				sheet.addCell(cellText);
				
				cellText = new Label(2, i + 1, jobs.get(i).getTheme(), formatCell);
				sheet.addCell(cellText);
				
				cellText = new Label(3, i + 1, jobs.get(i).getAuthor(), formatCell);
				sheet.addCell(cellText);
				
				cellText = new Label(4, i + 1, jobs.get(i).getTitle(), formatCell);
				sheet.addCell(cellText);
				
				cellText = new Label(5, i + 1, jobs.get(i).getUrl(), formatCell);
				sheet.addCell(cellText);
				
				cellText = new Label(6, i + 1, jobs.get(i).getPublishedDate().toString(), formatCell);
				sheet.addCell(cellText);
				
				cellText = new Label(7, i + 1, jobs.get(i).getContent(), formatCell);
				sheet.addCell(cellText);
				
			}
			
			workbook.write();
			workbook.close();
		} catch (IOException | WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
