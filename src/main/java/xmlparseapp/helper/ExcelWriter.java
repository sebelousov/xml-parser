package xmlparseapp.helper;

import java.util.List;

import xmlparseapp.entity.Job;

public interface ExcelWriter {
	public void write(List<Job> jobs);
}
