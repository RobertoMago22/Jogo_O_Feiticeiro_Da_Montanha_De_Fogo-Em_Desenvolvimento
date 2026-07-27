package Model;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;

public class Tela_Inventario extends VBox {
	
	private TableView<Item> tabela;
	private Button botao;
	
	
	public Tela_Inventario(Heroi heroi) {
		
		this.tabela = new TableView<>();
		this.botao = new Button("Usar");
		
		
		setAlignment(Pos.CENTER);
		getChildren().addAll(botao, tabela);
		
		TableColumn<Item, String> colNome = new TableColumn<>("Nome");
		colNome.setCellValueFactory(cellData -> cellData.getValue().nomeProperty());
		
		TableColumn<Item, Integer> colUnidade = new TableColumn<>("Quant.");
		colUnidade.setCellValueFactory(cellData -> cellData.getValue().unidadeProperty().asObject());
		
		tabela.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY_ALL_COLUMNS);
		tabela.getColumns().addAll(colNome, colUnidade);
		tabela.setItems(heroi.getInventario());
	}
	
	public Button getButton() {
		return botao;
	}
	
	public TableView<Item> getTableView() {
		return tabela;
	}

}
