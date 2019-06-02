package Models.File;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Header {
	private Map<String, String> headerNamesAndMappedNames;
	private Set<String> headerNames;

	public Header(Map<String, String> headerNamesAndMappedNames, Set<String> headerNames) {
		super();
		this.headerNamesAndMappedNames = headerNamesAndMappedNames;
		this.headerNames = headerNames;
	}

	public Header() {

	}

	public static Header createHeaderWithColumnNames(String[] headerLine, String[] columnNames) {
		Header header = new Header();
		Map<String, String> headerNamesWithMappedNames = new HashMap<>();
		for (int i = 0; i < headerLine.length; i++) {
			headerNamesWithMappedNames.put(headerLine[i], columnNames[i]);
		}
		header.setHeaderNamesAndMappedNames(headerNamesWithMappedNames);
		return header;
	}

	public Map<String, String> getHeaderNamesAndMappedNames() {
		return headerNamesAndMappedNames;
	}

	public void setHeaderNamesAndMappedNames(Map<String, String> headerNamesAndMappedNames) {
		this.headerNamesAndMappedNames = headerNamesAndMappedNames;
	}

	public Set<String> getHeaderNames() {
		return headerNames;
	}

	public void setHeaderNames(Set<String> headerNames) {
		this.headerNames = headerNames;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((headerNames == null) ? 0 : headerNames.hashCode());
		result = prime * result + ((headerNamesAndMappedNames == null) ? 0 : headerNamesAndMappedNames.hashCode());
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
		Header other = (Header) obj;
		if (headerNames == null) {
			if (other.headerNames != null)
				return false;
		} else if (!headerNames.equals(other.headerNames))
			return false;
		if (headerNamesAndMappedNames == null) {
			if (other.headerNamesAndMappedNames != null)
				return false;
		} else if (!headerNamesAndMappedNames.equals(other.headerNamesAndMappedNames))
			return false;
		return true;
	}

}
