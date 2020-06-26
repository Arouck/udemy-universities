package com.udemy.universities.ui.commons;

import com.udemy.universities.ui.navigator.UniversitiesNavigator;
import com.udemy.universities.ui.students.StudentLayoutFactory;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.navigator.SpringViewProvider;
import com.vaadin.ui.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

@SpringUI(path = UniversitiesMainUI.NAME)
@Title("Universities")
@Theme("valo")
public class UniversitiesMainUI extends UI {
    @Autowired
    private UniversitiesLogoLayoutFactory logoLayoutFactory;

    @Autowired
    private UniversitiesMenuFactory menuFactory;

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private SpringViewProvider viewProvider;

    public final static String NAME = "/ui";
    private Panel changeTab = new Panel();


    @Override
    protected void init(VaadinRequest request) {
        changeTab.setHeight("100%");

        VerticalLayout rootLayout = new VerticalLayout();
        rootLayout.setSizeFull();
        rootLayout.setMargin(true);

        Panel contentPanel = new Panel();
        contentPanel.setWidth("75%");
        contentPanel.setHeight("100%");

        Panel logoPanel = new Panel();
        logoPanel.setWidth("75%");
        logoPanel.setHeightUndefined();

        HorizontalLayout uiLayout = new HorizontalLayout();
        uiLayout.setSizeFull();
        uiLayout.setMargin(true);

        Component logo = logoLayoutFactory.createComponent();
        Component menu = menuFactory.createComponent();

        uiLayout.addComponent(menu);
        uiLayout.setComponentAlignment(menu, Alignment.TOP_CENTER);
        uiLayout.setExpandRatio(menu, 2);

        uiLayout.addComponent(changeTab);
        uiLayout.setComponentAlignment(changeTab, Alignment.TOP_CENTER);
        uiLayout.setExpandRatio(changeTab, 2);

        logoPanel.setContent(logo);

        contentPanel.setContent(uiLayout);

        rootLayout.addComponent(logoPanel);
        rootLayout.addComponent(contentPanel);
        rootLayout.setComponentAlignment(contentPanel, Alignment.MIDDLE_CENTER);
        rootLayout.setComponentAlignment(logoPanel, Alignment.TOP_CENTER);
        rootLayout.setExpandRatio(contentPanel, 1);

        initNavigator();

        setContent(rootLayout);
    }

    private void initNavigator() {
        UniversitiesNavigator navigator = new UniversitiesNavigator(this, changeTab);
        applicationContext.getAutowireCapableBeanFactory().autowireBean(navigator);
        navigator.addProvider(viewProvider);
        navigator.navigateTo(StudentLayoutFactory.NAME);
    }
}
