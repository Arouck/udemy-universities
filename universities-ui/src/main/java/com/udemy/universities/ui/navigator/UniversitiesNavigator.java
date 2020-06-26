package com.udemy.universities.ui.navigator;

import com.google.gwt.thirdparty.guava.common.base.Strings;
import com.vaadin.navigator.Navigator;
import com.vaadin.ui.SingleComponentContainer;
import com.vaadin.ui.UI;

public class UniversitiesNavigator extends Navigator {

    public UniversitiesNavigator(UI ui, SingleComponentContainer container) {
        super(ui, container);
    }

    private static UniversitiesNavigator getNavigator() {
        UI ui = UI.getCurrent();
        Navigator navigator = ui.getNavigator();

        return (UniversitiesNavigator) navigator;
    }

    public static void navigate(String path) {
        try {
            UniversitiesNavigator.getNavigator().navigateTo(path);
        } catch (Exception e) {
            return;
        }
    }

    @Override
    public void navigateTo(String viewName) {
        super.navigateTo(Strings.nullToEmpty(viewName));
    }
}
