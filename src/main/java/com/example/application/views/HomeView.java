package com.example.application.views;



import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.menubar.MenuBar;
//import com.vaadin.flow.component.charts.model.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.TabSheet;
import com.vaadin.flow.component.tabs.TabSheetVariant;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.wontlost.ckeditor.Config;
import com.wontlost.ckeditor.Constants.EditorType;
import com.wontlost.ckeditor.Constants.Language;
import com.wontlost.ckeditor.Constants.Toolbar;
import com.wontlost.ckeditor.VaadinCKEditor;
import com.wontlost.ckeditor.VaadinCKEditorBuilder;

@PageTitle("Home")
@Route(value = "home", layout = MainLayout.class)
public class HomeView extends HorizontalLayout {
	VaadinCKEditor decoupledEditor = new VaadinCKEditorBuilder().with(builder->{
		builder.editorType=EditorType.DECOUPLED;
		builder.editorData="Dcoupled Editor";
		//builder.config = config;
	}).createVaadinCKEditor();
	public HomeView(){
		this.setSizeFull();
		
		this.setClassName("mainPanel");
		add(leftPanel(), centrePanel(), rightPanel());
	}
	
	public Component leftPanel() {
		VerticalLayout left=new VerticalLayout();
		left.setClassName("panel");
		
		TextField test=new TextField();
		//left.add(test);
		left.setWidth("20%");
		//left.setSizeFull();
		return left;
	}
	
	public Component rightPanel() {
		VerticalLayout left=new VerticalLayout();
		left.setClassName("panel");
		TextField test=new TextField();
		//left.add(test);
		//left.setSizeFull();
		left.setWidth("35%");
		return left;
	}
	public Component centrePanel() {
		VerticalLayout left=new VerticalLayout();
		left.setClassName("panel");
		left.setPadding(true);
		left.add(centrePanelTop(), centrePanelMiddle(), centrePanelBottom());
		left.setSizeFull();
		//left.setWidth("60%");
		return left;
	}
	public Component centrePanelTop() {
		Div left=new Div();
		//left.setClassName("panel");
		H2 test = new H2("Photo Gallery");
		/**Document Editor*/
		Toolbar[] toolbar = new Toolbar[] {Toolbar.fontFamily, Toolbar.fontSize, Toolbar.fontColor, Toolbar.imageUpload, Toolbar.htmlEmbed, Toolbar.bold};
		Config config = new Config();
		config.setEditorToolBar(toolbar);
		config.setPlaceHolder("Here is a place holder");
		config.setUILanguage(Language.en_gb);
		
		decoupledEditor.setSizeFull();
		Button a =new Button("Try");
		a.addClickListener(e->abc());
		//Label test=new Label(");
		left.add(test, decoupledEditor,a);
		left.setSizeFull();
		//left.setWidth("60%");
		return left;
	}
	
	public void abc() {
		System.out.print(decoupledEditor.getValue());
	}
	public Component centrePanelMiddle() {
		VerticalLayout left=new VerticalLayout();
		left.setClassName("panel");
		H2 test = new H2("Welcome to Forests & Environment Department, Government of Meghalaya\r\n"
				+ "Welcome to the Meghalayan Age. We currently live in the Meghalayan Age. The past 4,200 years of earth’s geological history have been officially classified as Meghalayan Age. A stalagmite from the Mawmluh Cave of Meghalaya has provided chemical signature as evidence for the beginning of Meghalayan age.");
		//Label test=new Label(");
		//test.setSizeFull();
		//left.add(test);
		left.setSizeFull();
		//left.setWidth("60%");
		return left;
	}

	public Component centrePanelBottom() {
		TabSheet tabSheet = new TabSheet();
		
		tabSheet.add("Dashboard",
		        new Div(new Text("This is the Dashboard tab content")));
		tabSheet.add("Payment",
		        new Div(new Text("This is the Payment tab content")));
		tabSheet.add("Shipping",
		        new Div(new Text("This is the Shipping tab content")));
		//add(tabSheet);
		tabSheet.addThemeVariants(TabSheetVariant.LUMO_TABS_CENTERED);
		return tabSheet;
	}
}
