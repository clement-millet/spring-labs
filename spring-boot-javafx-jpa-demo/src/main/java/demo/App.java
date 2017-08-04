/*
 * Copyright 2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package demo;

import javafx.application.Preloader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Lazy;

import demo.projects.ui.ProjectsView;

/**
 * @author Thomas Darimont
 */
@Lazy
@SpringBootApplication
@SuppressWarnings("restriction")
public class App extends AbstractJavaFxApplicationSupport {

	/**
	 * Note that this is configured in application.properties
	 */
	@Value("${app.ui.title:Example App}")
	//
	private String windowTitle;

	@Autowired
	private ProjectsView projectsView;

	@Override
	public void start(Stage stage) throws Exception {

		notifyPreloader(new Preloader.StateChangeNotification(Preloader.StateChangeNotification.Type.BEFORE_START));

		stage.setTitle(windowTitle);
		stage.setScene(new Scene(projectsView.getView()));
		stage.setResizable(true);
		stage.centerOnScreen();
		stage.show();
	}

	public static void main(String[] args) {
		launchApp(App.class, args);
	}

}
