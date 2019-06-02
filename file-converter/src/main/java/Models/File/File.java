package Models.File;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;

import Models.Formatter.DataFormatter;

public class File {
	private Header header;
	private Collection<Line> content;
	@SuppressWarnings("rawtypes")
	private Map<Integer, DataFormatter> formatter;

	public File() {

	}

	@SuppressWarnings("rawtypes")
	public File(Header header, Collection<Line> content, Map<Integer,DataFormatter> formatter) {
		super();
		this.header = header;
		this.content = content;
		this.formatter=formatter;
	}

	public Header getHeader() {
		return header;
	}

	public void setHeader(Header header) {
		this.header = header;
	}

	public Collection<Line> getContent() {
		return content;
	}

	public void setContent(Collection<Line> content) {
		this.content = content;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((header == null) ? 0 : header.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		File other = (File) obj;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (header == null) {
			if (other.header != null)
				return false;
		} else if (!header.equals(other.header))
			return false;
		return true;
	}

	@SuppressWarnings("rawtypes")
	public Map<Integer, DataFormatter> getFormatter() {
		return formatter;
	}

	@SuppressWarnings("rawtypes")
	public void setFormatter(Map<Integer, DataFormatter> formatter) {
		this.formatter = formatter;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void applyFormattertoContent() throws Exception {
		for (Line line : content) {
			String[] contentPerLine = line.getContent();
			for (Entry<Integer, DataFormatter> formatter : formatter.entrySet()) {
				formatter.getValue().applyFormatter(contentPerLine[formatter.getKey()]);

			}

		}
	}
}
