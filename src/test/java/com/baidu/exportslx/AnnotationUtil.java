package com.baidu.exportslx;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AnnotationUtil {  
  
	public static List<ColumnTypeInfo> getColumnTypeInfos(Class<?> clazz) {
		List<ColumnTypeInfo> infos = new ArrayList<>();
		Field[] declaredFields = clazz.getDeclaredFields();
		for (Field field : declaredFields) {
			ColumnType annotation = field.getAnnotation(ColumnType.class);
			if (annotation != null) {
				ColumnTypeInfo info = new ColumnTypeInfo();
				info.setColumnName(annotation.columnName());
				info.setFieldIndex(annotation.index());
				info.setFieldName(field.getName());
				infos.add(info);
			}
		}
		Collections.sort(infos);
		return infos;
	}
  
    static class ColumnTypeInfo implements Comparable<ColumnTypeInfo>{
    	private String columnName;
    	private int fieldIndex;
    	private String fieldName;
    	
		public String getColumnName() {
			return columnName;
		}

		public void setColumnName(String columnName) {
			this.columnName = columnName;
		}

		public int getFieldIndex() {
			return fieldIndex;
		}

		public void setFieldIndex(int fieldIndex) {
			this.fieldIndex = fieldIndex;
		}

		public String getFieldName() {
			return fieldName;
		}

		public void setFieldName(String fieldName) {
			this.fieldName = fieldName;
		}

		@Override
		public int compareTo(ColumnTypeInfo o) {
			return this.fieldIndex - o.getFieldIndex();
		}

		@Override
		public String toString() {
			return "ColumnTypeInfo [columnName=" + columnName + ", fieldIndex=" + fieldIndex + ", fieldName="
					+ fieldName + "]";
		}
    	
    }
}  