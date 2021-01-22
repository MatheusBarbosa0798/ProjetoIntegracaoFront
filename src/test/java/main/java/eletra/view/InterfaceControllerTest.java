package main.java.eletra.view;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;

import de.saxsys.javafx.test.JfxRunner;

import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

 import javafx.scene.control.ComboBox;
import javafx.scene.control.TitledPane;
import javafx.scene.control.TreeView;
import main.java.eletra.Main;
import main.java.eletra.connection.URLConnecta;
import main.java.eletra.model.Meters;

@SuppressWarnings("unused")
@RunWith(JfxRunner.class)
public class InterfaceControllerTest {
	
	
	Meters meters = Mockito.mock(Meters.class);
	URLConnecta urlConnect = Mockito.mock(URLConnecta.class);
	
	InterfaceController ic = spy(InterfaceController.class);
	Main m = spy(Main.class);
	
	@Before
	@Test
	public void initTests() {
		//given
		PowerMockito.doNothing().when(ic).extractedUrlLoadLine();
		ic.comboBoxLine = new ComboBox<String>();
		ic.tpaneModel = new TitledPane();
		ic.listProd = new ArrayList<Meters>();
		ic.lines = new ArrayList<String>();
		ic.modelTree = new TreeView<String>();
		ic.tpaneLine = new TitledPane();
	}
	
	@Test
	public void cbbStartTest() {
		//when
		ic.loadLine();
		//then
		assertEquals("verifying the initial nulity of the combobox.", 
				null,
				ic.comboBoxLine.getSelectionModel().getSelectedItem() );
	}
	
	@Ignore
	public void treeRootTest00() {
		//when	
		ic.loadLine();
		ic.comboBoxLine.getSelectionModel().select(0);
		ic.loadModel();
		String a;
		String b;
		a = ic.comboBoxLine.getSelectionModel().getSelectedItem().toString();
		b = ic.modelTree.getRoot().getValue();
		//then
		assertEquals("Verifying if the TreeView root is the same as selected in the ComboBox.",
				a,b);
	 
	}
	
	@Ignore
	public void treeRootTest01() {
		//when	
		ic.loadLine();
		ic.comboBoxLine.getSelectionModel().select(1);
		ic.loadModel();
		String a;
		String b;
		a = ic.comboBoxLine.getSelectionModel().getSelectedItem().toString();
		b = ic.modelTree.getRoot().getValue();
		//then
		assertEquals("Verifying if the TreeView root is the same as selected in the ComboBox.",
				a,b);
	 
	}
	
	@Ignore
	public void treeRootTest02() {
		//when	
		ic.loadLine();
		ic.comboBoxLine.getSelectionModel().select(2);
		ic.loadModel();
		String a;
		String b;
		a = ic.comboBoxLine.getSelectionModel().getSelectedItem().toString();
		b = ic.modelTree.getRoot().getValue();
		//then
		assertEquals("Verifying if the TreeView root is the same as selected in the ComboBox.",
				a,b);
	 
	}
	
	@Ignore
	public void treeRootTest03() {
		//when	
		ic.loadLine();
		ic.comboBoxLine.getSelectionModel().select(3);
		ic.loadModel();
		String a;
		String b;
		a = ic.comboBoxLine.getSelectionModel().getSelectedItem().toString();
		b = ic.modelTree.getRoot().getValue();
		//then
		assertEquals("Verifying if the TreeView root is the same as selected in the ComboBox.",
				a,b);
	 
	}
	
	@Test
	public void updateDatabaseTest00() {
		//given
		ic.tpaneLine.setExpanded(true);
		//when 
		ic.updateDatabase();
		//then
		assertEquals("Checking if the refresh button is disabling the combobox's titlepane.",
				false,
				ic.tpaneLine.expandedProperty().get());
	}
	
	@Test
	public void updateDatabaseTest01() {
		//given
		//when
		ic.updateDatabase();
		//then
		verify(ic, times(1)).loadLine();
	}
	
	@Test
	public void initializeTest() {
		//given
		//when
		ic.initialize();
		//then
		verify(ic, times(1)).loadLine();
	}
	
}
