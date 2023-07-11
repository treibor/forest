package com.example.application.views;


import com.example.application.service.dbservice;
import com.example.application.views.about.AboutView;
import com.example.application.views.helloworld.HelloWorldView;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.charts.model.Background;
import com.vaadin.flow.component.contextmenu.MenuItem;
import com.vaadin.flow.component.contextmenu.SubMenu;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Header;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.ListItem;
import com.vaadin.flow.component.html.Nav;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.html.UnorderedList;
import com.vaadin.flow.component.menubar.MenuBar;
import com.vaadin.flow.component.menubar.MenuBarVariant;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.theme.lumo.LumoUtility.AlignItems;
import com.vaadin.flow.theme.lumo.LumoUtility.BoxSizing;
import com.vaadin.flow.theme.lumo.LumoUtility.Display;
import com.vaadin.flow.theme.lumo.LumoUtility.FlexDirection;
import com.vaadin.flow.theme.lumo.LumoUtility.FontSize;
import com.vaadin.flow.theme.lumo.LumoUtility.FontWeight;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;
import com.vaadin.flow.theme.lumo.LumoUtility.Height;
import com.vaadin.flow.theme.lumo.LumoUtility.ListStyleType;
import com.vaadin.flow.theme.lumo.LumoUtility.Margin;
import com.vaadin.flow.theme.lumo.LumoUtility.Overflow;
import com.vaadin.flow.theme.lumo.LumoUtility.Padding;
import com.vaadin.flow.theme.lumo.LumoUtility.TextColor;
import com.vaadin.flow.theme.lumo.LumoUtility.Whitespace;
import com.vaadin.flow.theme.lumo.LumoUtility.Width;
import org.vaadin.lineawesome.LineAwesomeIcon;

/**
 * The main view is a top-level placeholder for other views.
 */
public class MainLayout extends AppLayout {
	public dbservice dbservice;
    /**
     * A simple navigation item component, based on ListItem element.
     */
    public static class MenuItemInfo extends ListItem {

        private final Class<? extends Component> view;

        public MenuItemInfo(String menuTitle, Component icon, Class<? extends Component> view) {
            this.view = view;
            RouterLink link = new RouterLink();
            // Use Lumo classnames for various styling
            link.addClassNames(Display.FLEX, Gap.XSMALL, Height.MEDIUM, AlignItems.CENTER, Padding.Horizontal.SMALL,
                    TextColor.BODY);
            link.setRoute(view);

            Span text = new Span(menuTitle);
            // Use Lumo classnames for various styling
            text.addClassNames(FontWeight.MEDIUM, FontSize.MEDIUM, Whitespace.NOWRAP);

            if (icon != null) {
                link.add(icon);
            }
            link.add(text);
            add(link);
        }

        public Class<?> getView() {
            return view;
        }

    }

    public MainLayout(dbservice db) {
    	this.dbservice=db;
        addToNavbar(createHeaderContent());
    }

    private Component createHeaderContent() {
    	
        Header header = new Header();
        header.addClassNames(BoxSizing.BORDER, Display.FLEX, FlexDirection.COLUMN, Width.FULL);
        //header.addClassName("header");
        Div layout = new Div();
        layout.addClassNames(Display.FLEX, AlignItems.CENTER);

        //H1 appName = new H1("Forest");
        //appName.addClassNames(Margin.Vertical.MEDIUM, Margin.End.AUTO, FontSize.LARGE);
        Image img = new Image("./images/header.jpg", "placeholder plant");
        img.setWidthFull();
        layout.add(img);

        Nav nav = new Nav();
        nav.addClassNames(Display.FLEX, Overflow.AUTO, Padding.Horizontal.MEDIUM, Padding.Vertical.XSMALL);

        // Wrap the links in a list; improves accessibility
        UnorderedList list = new UnorderedList();
        list.addClassNames(Display.FLEX, Gap.SMALL, ListStyleType.NONE, Margin.NONE, Padding.NONE);
        nav.add(list);
        MenuBar menuBar = new MenuBar();
        menuBar.setWidthFull();
        menuBar.addThemeVariants(MenuBarVariant.LUMO_END_ALIGNED);
        menuBar.setOpenOnHover(true);
        menuBar.addClassName("menuBar");
        addItems(menuBar);
        //add(menuBar);
        

        header.add(layout,  menuBar);
        return header;
    }
    private void addItems(MenuBar menuBar) {
        menuBar.addItem("Home", e-> UI.getCurrent().navigate(TestView.class));
        MenuItem aboutus = menuBar.addItem("About Us");
        SubMenu aboutSubMenu = aboutus.getSubMenu();
        aboutSubMenu.addItem("Forest Department");
        aboutSubMenu.addItem("Mandate");
        aboutSubMenu.addItem("Organisational Structure");
        MenuItem share = menuBar.addItem("Share");
        SubMenu shareSubMenu = share.getSubMenu();
        MenuItem onSocialMedia = shareSubMenu.addItem("On social media");
        SubMenu socialMediaSubMenu = onSocialMedia.getSubMenu();
        socialMediaSubMenu.addItem("Facebook");
        socialMediaSubMenu.addItem("Twitter");
        socialMediaSubMenu.addItem("Instagram");
        shareSubMenu.addItem("By email");
        shareSubMenu.addItem("Get Link");
        MenuItem move = menuBar.addItem("Move");
        SubMenu moveSubMenu = move.getSubMenu();
        //long menucount=dbservice.getMenuCount(1);
		//for (int level = 1; level < 4; level++) {
        	int level=1;
			long menucount=dbservice.getMenuCount(level);
			for (int a = 0; a < menucount; a++) {
				MenuItem menu = menuBar.addItem(dbservice.getMenuList(level).get(a).getName(), e->getContents());
				long menuid=dbservice.getMenuList(level).get(a).getId();
				SubMenu firstsubmenu=menu.getSubMenu();
				int level2=2;
				long submenucount = dbservice.getMenuCount(level2);
				for (int b = 0; b < submenucount; b++) {
					firstsubmenu.addItem(dbservice.getMenuList(level2).get(b).getName());
				}
			}
		//}
        moveSubMenu.addItem("To folder");
        moveSubMenu.addItem("To trash", e-> UI.getCurrent().navigate(AboutView.class));
        //moveSubMenu., LineAwesomeIcon.GLOBE_SOLID.create(), HelloWorldView.class);
        //moveSubMenu.addItem("To trash", e-> {UI.getCurrent().navigate(HelloWorldView.class)});
        menuBar.addItem("Duplicate");
    }
    public void getContents() {
    	UI.getCurrent().navigate(HomeView.class);
    }
    private MenuItemInfo[] createMenuItems() {
        return new MenuItemInfo[]{ //
                new MenuItemInfo("Hello World", LineAwesomeIcon.GLOBE_SOLID.create(), HelloWorldView.class), //

                new MenuItemInfo("About", LineAwesomeIcon.FILE.create(), AboutView.class), //

        };
        
    }

}
