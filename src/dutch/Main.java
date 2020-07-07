package dutch;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.*;
import javafx.stage.Stage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main extends Application implements EventHandler<ActionEvent> {

    final static String url = "https://www.linkedin.com/in/criclerbianca/";

    static String testCulori = "testCulori.txt";
    static String testFructe = "testFructe.txt";
    static String testAnimale = "testAnimale.txt";
    static String testNumere = "testNumere.txt";
    static String testOperatii = "testOperatii.txt";

    static ArrayList<String> listaIntrebari = new ArrayList<>();
    static ArrayList<String> listaVar1 = new ArrayList<>();
    static ArrayList<String> listaVar2 = new ArrayList<>();
    static ArrayList<String> listaVar3 = new ArrayList<>();
    static ArrayList<String> listaVar4 = new ArrayList<>();
    static ArrayList<String> listaRaspunsuriCorecte = new ArrayList<>();
    static ArrayList<String> listaFeedback = new ArrayList<>();
    List<String> intrebariGresiteArrayList = new ArrayList<>();

    RadioButton radioButtonA, radioButtonB, radioButtonC, radioButtonD;
    Button buttonIncepeTestul = new Button("Start test");

    Button buttonTeorie= new Button("Teorie");
    Button buttonVerificaRaspunsMultipleChoice = new Button("Trimite raspunsul");
    Button buttonVerificaRaspunsScris = new Button("Trimite raspunsul");
    Button buttonUrmatoareaIntrebare = new Button("Urmatoarea intrebare");
    Button buttonUrmatoareaIntrebare2 = new Button("Urmatoarea intrebare");
    Button buttonIntrebariGresite = new Button("Verifica intrebari gresite");
    Button buttonInapoiDinIntrebariGresite = new Button("Inapoi");
    Button buttonInapoiDinEseu = new Button("Inapoi");
    Button buttonRefaTestul = new Button("Reia testul");
    Button buttonLinkedin = new Button("LinkedIn");
    Button buttonIncepatori = new Button("Incepator");
    Button buttonMediu = new Button("Mediu");
    Button buttonAvansat = new Button("Avansat");
    Button buttonBackToStart = new Button("Pagina initiala");

    Button buttonGramatica= new Button("Gramatica");
    Button buttonVocabular = new Button("Vocabular");
    Button buttonCulori = new Button("Culori");
    Button buttonFructe = new Button("Fructe");
    Button buttonAnimale = new Button("Animale");
    Button buttonNumere = new Button("Numere");

    Button buttonOperatii=new Button("Numere");
    TextField raspunsScris =new TextField();

    int index;
    int nrRaspunsuriCorecte;
    static int nrIntrebari;
    int result;
    int width = 900;
    int height = 600;
    StringBuilder guess;
    String guess2;
    StringBuilder helperFeedbackFinal = new StringBuilder("");
    String feedbackFinal;

    Text textEseu = new Text();
    StringBuilder stringBuilderTextEseu = new StringBuilder();

    HBox hBoxInceput;
    VBox vBoxIntrebari;
    VBox vBoxIntrebareSiVariante;
    HBox hBoxButonVerificare;
    HBox hBoxInceput1;
    VBox vBoxRezultate;
    VBox vBoxButoaneRezultate;
    VBox vBoxFeedback;
    VBox vBoxIntrebariGresite;
    VBox vBoxEseu;
    Label questionNrField = new Label();
    Text rezultat = new Text("Punctaj: ");
    Text questionText = new Text();
    Label bunVenit = new Label("Sa invatam olandeza impreuna!"+ "\n\n");
    Label materie = new Label("????????");
    Text rezultatTest = new Text();
    Label rezultatText = new Label();
    Text titluEseu = new Text("Titlu eseu");
    Label titluIntrebariGresite = new Label("Intrebarile la care ati gresit");
    Label intrebariGresiteText = new Label();
    Label feedbackText = new Label();
    Label raspunsCorectGresit = new Label();
    BorderPane borderPanePaginaIntrebari = new BorderPane();
    StackPane stackPaneFeedback = new StackPane();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("Platforma de invatare a limbii olandeze");
        radioButtonA = new RadioButton();
        radioButtonA.setWrapText(true);
        radioButtonB = new RadioButton();
        radioButtonB.setWrapText(true);
        radioButtonC = new RadioButton();
        radioButtonC.setWrapText(true);
        radioButtonD = new RadioButton();
        radioButtonD.setWrapText(true);

        feedbackText.setWrapText(true);
        intrebariGresiteText.setText(intrebariGresiteArrayList.toString());
        rezultatText.setTextAlignment(TextAlignment.CENTER);
        rezultat.setTextAlignment(TextAlignment.CENTER);
        titluEseu.setTextAlignment(TextAlignment.CENTER);
        materie.setFont(Font.font("arial", FontWeight.NORMAL, FontPosture.REGULAR, 40));
        rezultatText.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        titluEseu.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        titluIntrebariGresite.setFont(Font.font("verdana", FontWeight.MEDIUM, FontPosture.REGULAR, 20));
        questionNrField.setFont(Font.font("verdana", FontWeight.MEDIUM, FontPosture.REGULAR, 15));
        questionText.setFont(Font.font("verdana", FontWeight.MEDIUM, FontPosture.REGULAR, 20));
        feedbackText.setFont(Font.font("verdana", FontWeight.MEDIUM, FontPosture.REGULAR, 20));
        raspunsCorectGresit.setFont(Font.font("verdana", FontWeight.MEDIUM, FontPosture.REGULAR, 15));
        buttonIntrebariGresite.setDisable(true);
        intrebariGresiteText.setWrapText(true);
        intrebariGresiteText.setMaxWidth(width - 100);
        raspunsScris.setMaxWidth(width/2);

        //scena initiala - selectie nivel
        hBoxInceput1 = new HBox(50);
        hBoxInceput1.setPadding(new Insets(10, 12, 10, 12));
        buttonIncepatori.setAlignment(Pos.CENTER);
        buttonMediu.setAlignment(Pos.CENTER);
        hBoxInceput1.getChildren().addAll(buttonIncepatori, buttonMediu, buttonAvansat);
        hBoxInceput1.setAlignment(Pos.CENTER);

        VBox vBoxInceput1 = new VBox(50);
        vBoxInceput1.setPadding(new Insets(12, 10, 12, 10));
        bunVenit.setAlignment(Pos.CENTER);
        vBoxInceput1.getChildren().addAll(bunVenit, hBoxInceput1);
        vBoxInceput1.setAlignment(Pos.CENTER);
        vBoxInceput1.setPrefWidth(width);
        vBoxInceput1.setPrefWidth(height);
        bunVenit.setWrapText(false);
        bunVenit.setFont(Font.font("arial", FontWeight.NORMAL, FontPosture.REGULAR, 25));

        Scene sceneSelectieNivel = new Scene(vBoxInceput1, width, height);

        //scena selectie - gramatica/vocabular
        hBoxInceput = new HBox(50);
        hBoxInceput.setPadding(new Insets(15, 12, 15, 12));
        hBoxInceput.getChildren().addAll(buttonVocabular, buttonGramatica);
        hBoxInceput.setAlignment(Pos.CENTER);

        Scene sceneSelectieTip = new Scene(hBoxInceput, width, height);

        //scena selectie - tematica
        HBox hBoxTematici = new HBox(50);
        hBoxTematici.setPadding(new Insets(15, 12, 15, 12));
        hBoxTematici.setAlignment(Pos.CENTER);

        Scene sceneSelectieTematicaVocabular = new Scene(hBoxTematici, width, height);


        //Scena intrebarilor
        vBoxIntrebari = new VBox();
        vBoxIntrebari.setPadding(new Insets(15, 12, 15, 12));
        vBoxIntrebari.getChildren().addAll(questionNrField);
        vBoxIntrebari.setAlignment(Pos.CENTER);
        vBoxIntrebari.getStylesheets().add("dutch/css/vBoxIntrebari.css");


        StackPane stackPaneIntrebari = new StackPane();
        stackPaneIntrebari.setPadding(new Insets(60, 10, 10, 10));
        stackPaneIntrebari.getChildren().addAll(vBoxIntrebari);

        VBox vBoxVariante = new VBox(10);
        vBoxVariante.getChildren().addAll(radioButtonA, radioButtonB, radioButtonC, radioButtonD);
        radioButtonA.setWrapText(true);
        radioButtonB.setWrapText(true);
        radioButtonC.setWrapText(true);
        radioButtonD.setWrapText(true);
        radioButtonA.wrapTextProperty();
        radioButtonB.wrapTextProperty();
        radioButtonC.wrapTextProperty();
        radioButtonD.wrapTextProperty();
        radioButtonA.setMaxWidth(width / 1.5);
        radioButtonB.setMaxWidth(width / 1.5);
        radioButtonC.setMaxWidth(width / 1.5);
        radioButtonD.setMaxWidth(width / 1.5);

        Group groupVariante = new Group();
        groupVariante.getChildren().add(vBoxVariante);
        vBoxVariante.setAlignment(Pos.CENTER_LEFT);

        vBoxIntrebareSiVariante = new VBox(20);
        vBoxIntrebareSiVariante.setPadding(new Insets(15, 12, 15, 12));
        questionText.setWrappingWidth(width - 100);
        questionText.setTextAlignment(TextAlignment.CENTER);
        vBoxIntrebareSiVariante.setAlignment(Pos.CENTER);

        hBoxButonVerificare = new HBox(10);
        hBoxButonVerificare.setPadding(new Insets(15, 25, 25, 12));
        hBoxButonVerificare.setAlignment(Pos.BOTTOM_RIGHT);

        borderPanePaginaIntrebari.setTop(stackPaneIntrebari);
        borderPanePaginaIntrebari.setCenter(vBoxIntrebareSiVariante);
        borderPanePaginaIntrebari.setBottom(hBoxButonVerificare);
        borderPanePaginaIntrebari.setMaxWidth(width);
        borderPanePaginaIntrebari.setMaxHeight(height);

        Scene sceneIntrebari = new Scene(borderPanePaginaIntrebari, width, height);

        //scena feedback
        VBox vBoxCorectGresit = new VBox();
        vBoxCorectGresit.setPadding(new Insets(15, 12, 15, 12));
        vBoxCorectGresit.getChildren().add(raspunsCorectGresit);
        vBoxCorectGresit.setAlignment(Pos.CENTER);

        stackPaneFeedback.setPadding(new Insets(100, 10, 10, 10));
        stackPaneFeedback.getChildren().addAll(vBoxCorectGresit);

        feedbackText.setWrapText(true);
        feedbackText.setAlignment(Pos.CENTER);

        vBoxFeedback = new VBox();
        vBoxFeedback.setPadding(new Insets(15, 50, 15, 50));
        vBoxFeedback.getChildren().add(feedbackText);
        vBoxFeedback.setAlignment(Pos.CENTER);

        HBox hBoxButUrmIntreb = new HBox();
        hBoxButUrmIntreb.setPadding(new Insets(15, 100, 100, 12));
        hBoxButUrmIntreb.setAlignment(Pos.CENTER_RIGHT);

        VBox vBoxFeedbackTotal = new VBox(30);
        vBoxFeedbackTotal.getChildren().addAll(stackPaneFeedback, vBoxFeedback, hBoxButUrmIntreb);


        Scene sceneFeedback = new Scene(vBoxFeedbackTotal, width, height);

        //scena rezultate
        HBox hBoxButoaneEseuRomana = new HBox(10);
        hBoxButoaneEseuRomana.setPadding(new Insets(15, 12, 15, 12));
        hBoxButoaneEseuRomana.setAlignment(Pos.CENTER);
        //hBoxButoaneEseuRomana.getChildren().addAll(buttonEseu1, buttonEseu2, buttonEseu3);

        vBoxButoaneRezultate = new VBox(15);
        vBoxButoaneRezultate.setPadding(new Insets(15, 12, 15, 12));
        vBoxButoaneRezultate.setAlignment(Pos.CENTER);
        vBoxButoaneRezultate.getChildren().addAll(buttonIntrebariGresite, buttonRefaTestul, buttonBackToStart, hBoxButoaneEseuRomana);

        vBoxRezultate = new VBox(50);
        vBoxRezultate.setPadding(new Insets(50, 25, 25, 22));
        vBoxRezultate.getChildren().addAll(rezultatText, vBoxButoaneRezultate);
        vBoxRezultate.setAlignment(Pos.CENTER);

        VBox vBoxRezultat = new VBox(30);
        vBoxRezultat.setAlignment(Pos.CENTER);
        vBoxRezultat.setPrefSize(width, height);
        vBoxRezultat.getChildren().addAll(vBoxRezultate, vBoxButoaneRezultate);

        Pane paneRezultate = new Pane();
        paneRezultate.getChildren().add(vBoxRezultat);

        Scene sceneRezultate = new Scene(paneRezultate, width, height);

        //scena intrebari gresite
        vBoxIntrebariGresite = new VBox(10);
        vBoxIntrebariGresite.setPadding(new Insets(15, 15, 15, 15));
        buttonInapoiDinIntrebariGresite.setAlignment(Pos.BOTTOM_RIGHT);
        vBoxIntrebariGresite.getChildren().addAll(titluIntrebariGresite, intrebariGresiteText, buttonInapoiDinIntrebariGresite);
        vBoxIntrebariGresite.setAlignment(Pos.CENTER);

        ScrollPane scrollPaneIntrebariGresite = new ScrollPane();
        scrollPaneIntrebariGresite.setPadding(new Insets(10, 10, 10, 10));
        scrollPaneIntrebariGresite.setContent(vBoxIntrebariGresite);
        Scene sceneIntrebariGresite = new Scene(scrollPaneIntrebariGresite, width, height);


        //scena eseu
        vBoxEseu = new VBox(15);
        vBoxEseu.setPadding(new Insets(15, 12, 15, 12));
        vBoxEseu.getChildren().addAll(titluEseu, textEseu, buttonInapoiDinEseu);
        vBoxEseu.setAlignment(Pos.CENTER);

        ScrollPane scrollPaneEseu = new ScrollPane();
        scrollPaneEseu.setPadding(new Insets(10, 10, 10, 10));
        scrollPaneEseu.setContent(vBoxEseu);
        Scene sceneEseu = new Scene(scrollPaneEseu, width, height);
        textEseu.setWrappingWidth(sceneEseu.getWidth() - 50);

        // folosim css urile create
        sceneSelectieNivel.getStylesheets().add("dutch/css/firstpage.css");
        sceneSelectieNivel.getStylesheets().add("dutch/css/buttons.css");


        sceneSelectieTip.getStylesheets().add("dutch/css/firstpage.css");
        sceneSelectieTip.getStylesheets().add("dutch/css/buttons.css");

        sceneSelectieTematicaVocabular.getStylesheets().add("dutch/css/firstpage.css");
        sceneSelectieTematicaVocabular.getStylesheets().add("dutch/css/buttons.css");

        sceneIntrebari.getStylesheets().add("dutch/css/checkbox.css");
        sceneIntrebari.getStylesheets().add("dutch/css/buttonVerificaIntrebarea.css");
        sceneIntrebari.getStylesheets().add("dutch/css/intrebari.css");

        sceneFeedback.getStylesheets().add("dutch/css/buttons.css");
        sceneFeedback.getStylesheets().add("dutch/css/checkbox.css");
        sceneFeedback.getStylesheets().add("dutch/css/feedback.css");

        sceneRezultate.getStylesheets().add("dutch/css/firstpage.css");
        sceneRezultate.getStylesheets().add("dutch/css/buttons.css");

        sceneIntrebariGresite.getStylesheets().add("dutch/css/buttons.css");
        sceneIntrebariGresite.getStylesheets().add("dutch/css/intrebarigresite.css");


        sceneEseu.getStylesheets().add("dutch/css/buttons.css");
        sceneEseu.getStylesheets().add("dutch/css/eseu.css");

        primaryStage.setScene(sceneSelectieNivel);

        buttonIncepatori.setOnAction(actionEvent ->{
            materie.setText("Nivel incepator");
            hBoxTematici.getChildren().clear();
            hBoxTematici.getChildren().addAll(buttonCulori, buttonFructe, buttonAnimale, buttonNumere);
            vBoxIntrebareSiVariante.getChildren().clear();
            vBoxIntrebareSiVariante.getChildren().addAll(questionText, groupVariante);
            hBoxButonVerificare.getChildren().clear();
            hBoxButonVerificare.getChildren().add(buttonVerificaRaspunsMultipleChoice);
            hBoxButUrmIntreb.getChildren().clear();
            hBoxButUrmIntreb.getChildren().add(buttonUrmatoareaIntrebare);

            primaryStage.setScene(sceneSelectieTip);
        });

        buttonMediu.setOnAction(actionEvent ->{
            materie.setText("Nivel mediu");
            hBoxTematici.getChildren().clear();
            hBoxTematici.getChildren().addAll(buttonOperatii);
            vBoxIntrebareSiVariante.getChildren().clear();
            vBoxIntrebareSiVariante.getChildren().addAll(questionText, raspunsScris);
            hBoxButonVerificare.getChildren().clear();
            hBoxButonVerificare.getChildren().add(buttonVerificaRaspunsScris);
            hBoxButUrmIntreb.getChildren().clear();
            hBoxButUrmIntreb.getChildren().add(buttonUrmatoareaIntrebare2);

            primaryStage.setScene(sceneSelectieTip);
        });

        buttonAvansat.setOnAction(actionEvent ->{
            materie.setText("Nivel avansat");
            primaryStage.setScene(sceneSelectieTip);
        });

        buttonVocabular.setOnAction(actionEvent ->{
            materie.setText("Tematici");
            primaryStage.setScene(sceneSelectieTematicaVocabular);
        });

        buttonCulori.setOnAction(actionEvent -> {
            materie.setText("Culori");
            readFiles(testCulori, listaIntrebari, listaVar1, listaVar2,
                    listaVar3, listaVar4, listaRaspunsuriCorecte, listaFeedback);
            nrIntrebari = listaIntrebari.size();
            nextQuestion();
            primaryStage.setScene(sceneIntrebari);
        });

        buttonNumere.setOnAction(actionEvent -> {
            materie.setText("Numere");
            readFiles(testNumere, listaIntrebari, listaVar1, listaVar2,
                    listaVar3, listaVar4, listaRaspunsuriCorecte, listaFeedback);
            nrIntrebari = listaIntrebari.size();
            nextQuestion();
            primaryStage.setScene(sceneIntrebari);
        });

        buttonOperatii.setOnAction(actionEvent -> {
            materie.setText("Operatii");
            readFiles2(testOperatii, listaIntrebari, listaRaspunsuriCorecte, listaFeedback);
            nrIntrebari = listaIntrebari.size();
            nextQuestion2();
            primaryStage.setScene(sceneIntrebari);
        });

        buttonFructe.setOnAction(actionEvent -> {
            materie.setText("Fructe");
            readFiles(testFructe, listaIntrebari, listaVar1, listaVar2,
                    listaVar3, listaVar4, listaRaspunsuriCorecte, listaFeedback);
            nrIntrebari = listaIntrebari.size();
            nextQuestion();
            primaryStage.setScene(sceneIntrebari);
        });

        buttonAnimale.setOnAction(actionEvent -> {
            materie.setText("Animale");
            readFiles(testAnimale, listaIntrebari, listaVar1, listaVar2,
                    listaVar3, listaVar4, listaRaspunsuriCorecte, listaFeedback);
            nrIntrebari = listaIntrebari.size();
            nextQuestion();
            primaryStage.setScene(sceneIntrebari);
        });

        buttonIncepeTestul.setOnAction(actionEvent -> {
            nextQuestion();
            primaryStage.setScene(sceneIntrebari);
        });

        buttonVerificaRaspunsMultipleChoice.setOnAction(actionEvent -> {
            guess = new StringBuilder();
            if (radioButtonA.isSelected()) {
                guess.append("A");
            }
            if (radioButtonB.isSelected()) {
                guess.append("B");
            }
            if (radioButtonC.isSelected()) {
                guess.append("C");
            }
            if (radioButtonD.isSelected()) {
                guess.append("D");
            }
            if (guess.toString().equals(listaRaspunsuriCorecte.get(index))) {
                nrRaspunsuriCorecte++;
            }

//            radioButtonA.setDisable(true);
//            radioButtonB.setDisable(true);
//            radioButtonC.setDisable(true);
//            radioButtonD.setDisable(true);
//            buttonUrmatoareaIntrebare.setDisable(false);
            primaryStage.setScene(sceneFeedback);
            displayAnswer();
        });

        buttonVerificaRaspunsScris.setOnAction(actionEvent -> {
            guess2 = raspunsScris.getText().trim();
            if (guess2.equals(listaRaspunsuriCorecte.get(index))) {
                nrRaspunsuriCorecte++;
            }
            primaryStage.setScene(sceneFeedback);
            displayAnswer2();
        });

        buttonUrmatoareaIntrebare.setOnAction(actionEvent -> {
            index++;
            raspunsCorectGresit.setText("");
            radioButtonA.setDisable(false);
            radioButtonB.setDisable(false);
            radioButtonC.setDisable(false);
            radioButtonD.setDisable(false);
            if (index == listaIntrebari.size() - 1) {
                buttonUrmatoareaIntrebare.setText("Vezi rezultate");
            }
            if (index >= listaIntrebari.size()) {
                results();
                primaryStage.setScene(sceneRezultate);
            } else {
                primaryStage.setScene(sceneIntrebari);
                nextQuestion();
            }
        });

        buttonUrmatoareaIntrebare2.setOnAction(actionEvent -> {
            raspunsScris.setText("");
            index++;
            raspunsCorectGresit.setText("");
            if (index == listaIntrebari.size() - 1) {
                buttonUrmatoareaIntrebare2.setText("Vezi rezultate");
            }
            if (index >= listaIntrebari.size()) {
                results();
                primaryStage.setScene(sceneRezultate);
            } else {
                primaryStage.setScene(sceneIntrebari);
                nextQuestion2();
            }
        });


        buttonVerificaRaspunsMultipleChoice.setDefaultButton(true);
        buttonVerificaRaspunsScris.setDefaultButton(true);
        buttonUrmatoareaIntrebare.setDefaultButton(true);
        buttonUrmatoareaIntrebare2.setDefaultButton(true);
        buttonIncepeTestul.setDefaultButton(true);
        buttonInapoiDinIntrebariGresite.setDefaultButton(true);
        buttonInapoiDinEseu.setDefaultButton(true);
        buttonIncepatori.setFocusTraversable(true);
        buttonMediu.setFocusTraversable(true);

        buttonIntrebariGresite.setOnAction(actionEvent ->
                primaryStage.setScene(sceneIntrebariGresite));

        buttonInapoiDinEseu.setOnAction(actionEvent -> {
            stringBuilderTextEseu.delete(0, stringBuilderTextEseu.length());
            textEseu.setText("");
            primaryStage.setScene(sceneRezultate);
        });

        buttonInapoiDinIntrebariGresite.setOnAction(actionEvent -> {
            primaryStage.setScene(sceneRezultate);
        });

        buttonRefaTestul.setOnAction(actionEvent -> {
            helperFeedbackFinal.delete(0, helperFeedbackFinal.length());
            index = 0;
            nrRaspunsuriCorecte = 0;
            buttonUrmatoareaIntrebare.setText("Urmatoarea intrebare");
            listaIntrebari.clear();
            listaVar1.clear();
            listaVar2.clear();
            listaVar3.clear();
            listaVar4.clear();
            listaRaspunsuriCorecte.clear();
            listaFeedback.clear();
            primaryStage.setScene(sceneSelectieTematicaVocabular);
        });

        buttonBackToStart.setOnAction(actionEvent -> {
            helperFeedbackFinal.delete(0, helperFeedbackFinal.length());
            index = 0;
            nrRaspunsuriCorecte = 0;
            buttonUrmatoareaIntrebare.setText("Urmatoarea intrebare");
            listaIntrebari.clear();
            listaVar1.clear();
            listaVar2.clear();
            listaVar3.clear();
            listaVar4.clear();
            listaRaspunsuriCorecte.clear();
            listaFeedback.clear();
            primaryStage.setScene(sceneSelectieNivel);
        });

        primaryStage.setResizable(true);
        primaryStage.show();

    }


    public void nextQuestion() {
        if (index >= nrIntrebari) {
            results();
        } else {
            questionNrField.setText("Intrebarea numarul " + (index + 1) + " din " + nrIntrebari + ":");
            questionText.setText(listaIntrebari.get(index));
            radioButtonA.setText(listaVar1.get(index));

            radioButtonA.setSelected(false);
            radioButtonB.setText(listaVar2.get(index));
            radioButtonB.setSelected(false);
            radioButtonC.setText(listaVar3.get(index));
            radioButtonC.setSelected(false);
            radioButtonD.setText(listaVar4.get(index));
            radioButtonD.setSelected(false);
        }
    }
    public void nextQuestion2() {
        if (index >= nrIntrebari) {
            results();
        } else {
            questionNrField.setText("Intrebarea numarul " + (index + 1) + " din " + nrIntrebari + ":");
            questionText.setText(listaIntrebari.get(index));
        }
    }

    public void displayAnswer() {
        if (guess.toString().equals(listaRaspunsuriCorecte.get(index))) {
            raspunsCorectGresit.setText("Răspuns corect!");
            feedbackText.setText("Felicitari!");
        } else {
            raspunsCorectGresit.setText("Raspuns gresit!");
            feedbackText.setText(listaFeedback.get(index));
            helperFeedbackFinal.append("• " + listaIntrebari.get(index) + "\n" +
                    listaVar1.get(index) + "\n" +
                    listaVar2.get(index) + "\n" +
                    listaVar3.get(index) + "\n" +
                    listaVar4.get(index) + "\n" + "\n");
        }
    }

    public void displayAnswer2() {
        if (guess2.equals(listaRaspunsuriCorecte.get(index))) {
            raspunsCorectGresit.setText("Răspuns corect!");
            feedbackText.setText("Felicitari!");
        } else {
            raspunsCorectGresit.setText("Raspuns gresit!");
            feedbackText.setText(listaFeedback.get(index));
            helperFeedbackFinal.append("• " + listaIntrebari.get(index)+ "\n");
        }
    }

    public void results() {
        result = (int) ((nrRaspunsuriCorecte / (double) nrIntrebari) * 100);
        rezultatTest.setText(String.valueOf(result) + "%");
        if (result >= 50) {
            rezultatText.setText("Rezultat: " + result + "%" +
                    "\nAi raspuns corect la " + nrRaspunsuriCorecte + " intrebari din " + nrIntrebari + ".\n" +
                    "\n\nFelicitari! Ati trecut testul.");

        } else {
            rezultatText.setText("Rezultat: " + result + "%" +
                    "\nAi raspuns corect la " + nrRaspunsuriCorecte + " intrebari din " + nrIntrebari );
        }

        feedbackFinal = helperFeedbackFinal.toString();
        if (!"".equals(feedbackFinal)) {
            intrebariGresiteText.setText(feedbackFinal);
            titluIntrebariGresite.setText("Intrebarile la care ati gresit");
            buttonIntrebariGresite.setDisable(false);
        } else {
            intrebariGresiteText.setText("Nu ati gresit nicio intrebare.");
            titluIntrebariGresite.setText("Felicitari! ");
            buttonIntrebariGresite.setDisable(true);
        }
    }


    @Override
    public void handle(ActionEvent actionEvent) {
    }


    public static void readImage(Rectangle rectangle, String caleImagineRectangle)  {
        ClassLoader classLoader = Main.class.getClassLoader();
        URL imageResource = classLoader.getResource(caleImagineRectangle);
        if (imageResource == null) {
            throw new RuntimeException("Resource not found : " + caleImagineRectangle);
        }
        rectangle.setFill(new ImagePattern(new Image(imageResource.toExternalForm()), 0, 0, 1, 1, true));
    }

    public static void readFiles(String fileName, ArrayList<String> intrebare,
                                 ArrayList<String>var1, ArrayList<String>var2, ArrayList<String>var3,
                                 ArrayList<String> var4, ArrayList<String> raspuns, ArrayList<String> feedback) {
        ClassLoader classLoader = Main.class.getClassLoader();
        Scanner input = new Scanner(classLoader.getResourceAsStream(fileName));
        while (input.hasNext()) {
            String intr = input.nextLine();
            intrebare.add(intr);
            String v1 = input.nextLine();
            var1.add(v1);
            String v2 = input.nextLine();
            var2.add(v2);
            String v3 = input.nextLine();
            var3.add(v3);
            String v4 = input.nextLine();
            var4.add(v4);
            String rasp = input.nextLine();
            raspuns.add(rasp);
            String feed = input.nextLine();
            feedback.add(feed);
        }
    }

    public static void readFiles2(String fileName, ArrayList<String> intrebare,
                                  ArrayList<String> raspuns, ArrayList<String> feedback) {
        ClassLoader classLoader = Main.class.getClassLoader();
        Scanner input = new Scanner(classLoader.getResourceAsStream(fileName));
        while (input.hasNext()) {
            String intr = input.nextLine();
            intrebare.add(intr);
            String rasp = input.nextLine();
            raspuns.add(rasp);
            feedback.add(rasp);
        }
    }

    public static void readEssay(String fileName, StringBuilder stringBuilderTextEseu) throws IOException {
        ClassLoader classLoader = Main.class.getClassLoader();
        BufferedReader reader
                = new BufferedReader(new InputStreamReader(classLoader.getResourceAsStream(fileName)));
        int theCharNum = reader.read();
        while (theCharNum != -1) {
            char theChar = (char) theCharNum;
            stringBuilderTextEseu.append(theChar);
            theCharNum = reader.read();
        }
    }

}