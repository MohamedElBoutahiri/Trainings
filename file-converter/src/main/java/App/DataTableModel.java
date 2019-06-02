package App;

import java.util.Vector;

import javax.swing.table.DefaultTableModel;

public class DataTableModel extends DefaultTableModel {

    public DataTableModel(Object[] table, Object[] header) {
    super(
    			new Boolean[][] {
    				{true, false, null},
    				{null, null, null},
    				{null, null, null},
    			},
    			new String[] {
    				"New column", "New column", "New column"
    			}
    		);
      
  
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
      Class clazz = String.class;
      switch (columnIndex) {
        case 0:
          clazz = Integer.class;
          break;
        case 1:
          clazz = Boolean.class;
          break;
      }
      return clazz;
    }

    @Override
    public boolean isCellEditable(int row, int column) {
      return column == 1;
    }

    @Override
    public void setValueAt(Object aValue, int row, int column) {
      if (aValue instanceof Boolean && column == 1) {
        System.out.println(aValue);
        Vector rowData = (Vector)getDataVector().get(row);
        rowData.set(1, (boolean)aValue);
        fireTableCellUpdated(row, column);
      }
    }

  }
