package com.udemy.universities.ui.universities;

import com.udemy.universities.ui.commons.UniversitiesMainUI;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

@SpringView(name = UniversityLayoutFactory.NAME, ui = UniversitiesMainUI.class)
public class UniversityLayoutFactory extends VerticalLayout implements View {

    public static final String NAME = "operations";

    public void enter(ViewChangeListener.ViewChangeEvent event) {
        addComponent(new Label("University layout..."));
    }
}
