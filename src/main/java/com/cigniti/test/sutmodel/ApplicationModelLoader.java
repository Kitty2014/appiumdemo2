package com.cigniti.test.sutmodel;

import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Properties;

public class ApplicationModelLoader {

    private Path modelBasePath;
    private Path screenListFile = FileSystems.getDefault().getPath("screen-list.properties");

    public ApplicationModelLoader(String basePath) {
        this.modelBasePath = FileSystems.getDefault().getPath(basePath);
    }

    public void loadModelFromFiles(ApplicationModel model) throws IOException {
        Properties screens = loadScreenDirsPaths();
        for (String screenName: screens.stringPropertyNames()) {
            BasicScreen screen = loadAllElements(screenName, screens.getProperty(screenName));
            model.loadScreen(screenName, screen);
        }
    }

    private Properties loadScreenDirsPaths() throws IOException {
        return loadFromFileInPath(modelBasePath.resolve(screenListFile));
    }

    private BasicScreen loadAllElements(String name, String screenDataDirName) throws IOException {
        BasicScreen screen = new BasicScreen(name);
        File screenDir = modelBasePath.resolve(screenDataDirName).toFile();
        File[] directoryListing = screenDir.listFiles();
        if (directoryListing != null) {
            for (File elementData: directoryListing) {
                screen.withElement(loadElementFromFile(elementData, screen));
            }
        }
        return screen;
    }

    private BasicElement loadElementFromFile(File elementData, BasicScreen screen) throws IOException {
        Properties props = loadFromFile(elementData);
        BasicElement element = new BasicElement(elementData.getName(), screen);
        return element.withProperties(props);
    }

    private Properties loadFromFile(File elementData) throws IOException {
        Properties props = new Properties();
        InputStream is = new FileInputStream(elementData);
        props.load(is);
        return props;
    }

    private Properties loadFromFileInPath(Path path) throws IOException {
        return loadFromFile(path.toFile());
    }
}
