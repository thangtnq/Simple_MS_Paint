package main;

import MouseHandler.MouseHandler;
import controller.Controller;
import controller.IJPaintController;
import controller.JPaintController;
import model.interfaces.IApplicationState;
import model.persistence.ApplicationState;
import view.gui.Gui;
import view.gui.GuiWindow;
import view.gui.PaintCanvas;
import view.interfaces.IGuiWindow;
import view.interfaces.IUiModule;

public class Main {
    public static void main(String[] args){
        PaintCanvas paintCanvas = PaintCanvas.getInstance();
        IGuiWindow guiWindow = new GuiWindow(paintCanvas);
        IUiModule uiModule = new Gui(guiWindow);
        IApplicationState appState = new ApplicationState(uiModule);
        IJPaintController controller = new JPaintController(uiModule, appState);
        controller.setup();

        MouseHandler mouse = new MouseHandler();
        paintCanvas.addMouseListener(mouse);
        paintCanvas.addMouseMotionListener(mouse);
        paintCanvas.requestFocus();
        Controller.setup(mouse, appState);
    }
}
