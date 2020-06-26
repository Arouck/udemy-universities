package com.udemy.universities.ui.students;

import com.udemy.universities.ui.commons.UniversitiesMainUI;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

@SpringView(name = StudentLayoutFactory.NAME, ui = UniversitiesMainUI.class)
public class StudentLayoutFactory extends VerticalLayout implements View {

    public static final String NAME = "addstudent";

    public void enter(ViewChangeListener.ViewChangeEvent event) {
        addComponent(new Label("Student layout..."));
    }
}
