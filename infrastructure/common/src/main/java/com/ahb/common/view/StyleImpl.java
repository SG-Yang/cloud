package com.ahb.common.view;

/**
 * Created by aheroboy on 12/4/2018.
 */
public class StyleImpl implements Style {
    private String style;
    private String classId;

    public String getStyle() {
        return style;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public void setStyle(String style) {
        this.style = style;
    }
}
