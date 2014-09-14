package com.cigniti.test.sutmodel;

import com.cigniti.test.appiumsession.TestsExecutionContext;

import java.util.HashMap;

import static com.cigniti.test.sutmodel.ModelIdentifier.getModelId;

public final class ApplicationModelFactory {

    private static ApplicationModelLoader loader;

    private static HashMap<String, ApplicationModel> models = new HashMap<String, ApplicationModel>();



    public static void registerModel(ApplicationModel model) {

        models.put(getModelId(model).toString(), model);
    }

    public static ApplicationModel getModel(TestsExecutionContext context) {
        return models.get(getModelId(context).toString());
    }

}
