package com.udemy.universities.ui.commons;

import com.udemy.universities.ui.navigator.UniversitiesNavigator;
import com.udemy.universities.utils.StringUtils;
import com.vaadin.data.Property;
import com.vaadin.ui.Component;
import com.vaadin.ui.Tree;
import com.vaadin.ui.VerticalLayout;

@org.springframework.stereotype.Component
public class UniversitiesMenuFactory implements UIComponentBuilder {

    private static class UniversitiesMenu extends VerticalLayout implements Property.ValueChangeListener {
        private Tree mainMenu;

        public UniversitiesMenu init() {
            mainMenu = new Tree();
            mainMenu.addValueChangeListener(this);

            return this;
        }

        public UniversitiesMenu layout() {
            setWidth("100%");
            setHeightUndefined();

            mainMenu.addItem(StringUtils.MENU_STUDENT.getString());
            mainMenu.addItem(StringUtils.MENU_UNIVERSITY.getString());

            mainMenu.expandItem(StringUtils.MENU_STUDENT.getString());
            mainMenu.expandItem(StringUtils.MENU_UNIVERSITY.getString());

            mainMenu.addItem(StringUtils.MENU_ADD_STUDENT.getString());
            mainMenu.addItem(StringUtils.MENU_REMOVE_STUDENT.getString());

            mainMenu.setChildrenAllowed(StringUtils.MENU_ADD_STUDENT.getString(), false);
            mainMenu.setChildrenAllowed(StringUtils.MENU_REMOVE_STUDENT.getString(), false);

            mainMenu.setParent(StringUtils.MENU_ADD_STUDENT.getString(), StringUtils.MENU_STUDENT.getString());
            mainMenu.setParent(StringUtils.MENU_REMOVE_STUDENT.getString(), StringUtils.MENU_STUDENT.getString());

            mainMenu.addItem(StringUtils.MENU_OPERATIONS.getString());
            mainMenu.setChildrenAllowed(StringUtils.MENU_OPERATIONS.getString(), false);
            mainMenu.setParent(StringUtils.MENU_OPERATIONS.getString(), StringUtils.MENU_UNIVERSITY.getString());

            addComponent(mainMenu);

            return this;
        }

        public void valueChange(Property.ValueChangeEvent event) {
            String selectedItem = (String) event.getProperty().getValue();

            if(selectedItem != null) {
                String path = selectedItem.toLowerCase().replaceAll("\\s+", "");
                UniversitiesNavigator.navigate(path);
            }
        }
    }

    public Component createComponent() {
        return new UniversitiesMenu().init().layout();
    }
}
