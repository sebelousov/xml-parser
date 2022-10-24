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
		File file = new File(".");
		String path = file.getAbsolutePath();
		String fileLocation = path.substring(0, path.length() - 1) + "temp.xls";
		
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
			
			Label headerCell = new Label(0, 0, "Job", formatCell);
			sheet.setColumnView(0, 20);
			sheet.addCell(headerCell);
			
			headerCell = new Label(1, 0, "Order", formatCell);
			sheet.setColumnView(1, 20);
			sheet.addCell(headerCell);
			
			headerCell = new Label(2, 0, "Theme", formatCell);
			sheet.setColumnView(2, 20);
			sheet.addCell(headerCell);
			
			headerCell = new Label(3, 0, "Author", formatCell);
			sheet.setColumnView(3, 20);
			sheet.addCell(headerCell);
			
			headerCell = new Label(4, 0, "Title", formatCell);
			sheet.setColumnView(4, 20);
			sheet.addCell(headerCell);
			
			headerCell = new Label(5, 0, "URL", formatCell);
			sheet.setColumnView(5, 20);
			sheet.addCell(headerCell);
			
			headerCell = new Label(6, 0, "Date", formatCell);
			sheet.setColumnView(6, 20);
			sheet.addCell(headerCell);
			
			headerCell = new Label(7, 0, "Content", formatCell);
			sheet.setColumnView(7, 20);
			sheet.addCell(headerCell);
			
			if (jobs != null) {
				Label cellText = null;
				Number cellNumber = null;
				for (int i = 0; i< jobs.size(); i++) {
					cellNumber = new Number(0, i + 1, jobs.get(i).getId(), formatCell);
					sheet.addCell(cellNumber);
					
					cellNumber = new Number(1, i + 1, jobs.get(i).getOrder(), formatCell);
					sheet.addCell(cellNumber);
					
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
			}
			
			workbook.write();
			workbook.close();
		} catch (IOException | WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
