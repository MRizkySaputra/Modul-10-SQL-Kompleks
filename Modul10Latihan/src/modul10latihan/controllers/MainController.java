/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package modul10latihan.controllers;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import java.time.LocalDate;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import modul10latihan.dao.BukuDAO;
import modul10latihan.dao.KategoriBukuDAO;
import modul10latihan.models.Buku;
import modul10latihan.models.KategoriBuku;

/**
 *
 * @author Muhammad Rizky S
 */
public class MainController implements Initializable {

    @FXML private ComboBox<KategoriBuku> cbxKategori;
    @FXML private ComboBox<String> cbxSorting;

    @FXML private DatePicker dpcDari;
    @FXML private DatePicker dpcSampai;

    @FXML private TextField txtJudul;

    @FXML private Button btnFilter;
    @FXML private Button btnSorting;
    @FXML private Button btnClearFilter;
    @FXML private Button btnClearSorting;
    @FXML private Button btnClearAll;

    @FXML private TableView<Buku> tblViewBuku;
    @FXML private TableColumn<Buku, String> colJudul;
    @FXML private TableColumn<Buku, String> colKategori;
    @FXML private TableColumn<Buku, String> colKodeBuku;
    @FXML private TableColumn<Buku, String> colPenerbit;
    @FXML private TableColumn<Buku, String> colPengarang;
    @FXML private TableColumn<Buku, String> colTahun;
    @FXML private TableColumn<Buku, String> colEdisi;
    @FXML private TableColumn<Buku, String> colPengadaan;

    private ObservableList<Buku> bukuList;

    //Awa Filtering
    private void loadDataKategori() {
        KategoriBukuDAO kategoriBukuDAO = new KategoriBukuDAO();

        ObservableList<KategoriBuku> kategoriBukuList = FXCollections.observableArrayList(kategoriBukuDAO.getAllKategoriBuku());
        cbxKategori.setItems(kategoriBukuList);
    }

    public String getSelectedKodeKategori() {
        KategoriBuku selectedKategoriBuku = cbxKategori.getSelectionModel().getSelectedItem();

        if (selectedKategoriBuku != null) {
            return selectedKategoriBuku.getKodeKategori();
        }
        return null;
    }

    private void loadDataBuku() {
        bukuList = FXCollections.observableArrayList(BukuDAO.getAllBuku());
        tblViewBuku.setItems(bukuList);
    }

    @FXML
    private void handleBtnFilter(ActionEvent event) {
        bukuList.clear();
        BukuDAO.filterJudul = txtJudul.getText();
        LocalDate dari = dpcDari.getValue();
        LocalDate sampai = dpcSampai.getValue();
        if (dari != null || sampai != null) {
            BukuDAO.filterTanggalDari = dari.toString();
            BukuDAO.filterTanggalSampai = sampai.toString();
        }

        if (getSelectedKodeKategori() != null) {
            BukuDAO.filterKategori = getSelectedKodeKategori();
        }

        loadDataBuku();
    }

    private void initComboboxSorting() {
        cbxSorting.setItems(
                FXCollections.observableArrayList(
                        "",
                        "Judul A-Z",
                        "Judul Z-A",
                        "Pengadaan Terbaru",
                        "Pengadaan Lama"
                )
        );
        cbxSorting.getSelectionModel().selectFirst();
    }
    //Akhir Filtering
    
    //Awal Sorting
    public String getSelectedComboboxSorting() {
        String sortingOption = cbxSorting.getSelectionModel().getSelectedItem();
        return sortingOption;
    }

    private void loadTableBuku() {
        bukuList = FXCollections.observableArrayList(BukuDAO.getAllBuku());
        tblViewBuku.setItems(bukuList);
    }

    @FXML
    private void handleButtonSorting(ActionEvent event) {
        bukuList.clear();
        BukuDAO.sortingOption = getSelectedComboboxSorting();

        loadTableBuku();
    }
    //Akhir Sorting

    @FXML
    private void handleClearFilter(ActionEvent event) {
        txtJudul.clear();
        dpcDari.setValue(null);
        dpcSampai.setValue(null);
        cbxKategori.getSelectionModel().clearSelection();

        BukuDAO.filterJudul = "";
        BukuDAO.filterTanggalDari = "";
        BukuDAO.filterTanggalSampai = "";
        BukuDAO.filterKategori = "";

        loadDataBuku();
    }

    @FXML
    private void handleClearSorting(ActionEvent event) {
        cbxSorting.getSelectionModel().selectFirst(); // kosong
        BukuDAO.sortingOption = "";
        loadTableBuku();
    }

    @FXML
    private void handleClearAll(ActionEvent event) {
        handleClearFilter(event);
        handleClearSorting(event);
    }
    
    private void refreshTable() {
    bukuList = FXCollections.observableArrayList(BukuDAO.getAllBuku());
    tblViewBuku.setItems(bukuList);
    }


    private void initTableViewBuku() {
        colKodeBuku.setCellValueFactory(
                new PropertyValueFactory<>("kodeBuku")
        );
        colKategori.setCellValueFactory(
                new PropertyValueFactory<>("namaKategori")
        );
        colJudul.setCellValueFactory(
                new PropertyValueFactory<>("judul")
        );
        colPengarang.setCellValueFactory(
                new PropertyValueFactory<>("pengarang")
        );
        colPenerbit.setCellValueFactory(
                new PropertyValueFactory<>("penerbit")
        );
        colTahun.setCellValueFactory(
                new PropertyValueFactory<>("tahun")
        );
        colEdisi.setCellValueFactory(
                new PropertyValueFactory<>("edisi")
        );
        colPengadaan.setCellValueFactory(
                new PropertyValueFactory<>("tanggalPengadaan")
        );

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        //Filtering
        loadDataKategori();
        initTableViewBuku();
        loadDataBuku();

        //Sorting
        initComboboxSorting();
        initTableViewBuku();
        loadTableBuku();
        
        //Clear
        refreshTable();
    }

}
