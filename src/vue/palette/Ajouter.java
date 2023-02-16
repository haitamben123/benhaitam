package vue.palette;

import dao.daoFiles.ClientDao;
import model.Client;
import model.Sexe;
import vue.palette.TablePanel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Ajouter extends JFrame{

        private Container myViewContainer;
        private JPanel titlePanel,formPanel,buttonsPannel;
        private JLabel lbl_title,lbl_login,lbl_pass,lbl_email,lbl_tel,lbl_cin,lbl_prenom,lbl_nom,lbl_sexe;
        private JTextField txt_login,txt_email,txt_tel,txt_cin,txt_nom,txt_prenom,txt_sexe;
        private JPasswordField txt_pass;
        private JButton btn_add,btn_cancel;



        //constructeur
        public Ajouter(String title){
            //initialisation du conteneur principale
            initContainer();
            //titre
            setTitle(title);
            //dimensionner
            setSize(600,600);
            //la mettre au milieu
            setLocationRelativeTo(null);
            //fixer la taille de la fenetre
            setResizable(false);
            //rendre la fenetre visible
            setVisible(true);
        }





        //init container
        public void initContainer(){
            //referencer ou attacher notre conteneur de base par la reference myViewContainer
            this.myViewContainer=this.getContentPane();
            //personnalisation de notre conteneur
            //affecter un BorderLayout a notre conteneur pour le decouper sous forme de Bords
            myViewContainer.setLayout(new BorderLayout());
            //ajouter les panneaux aux bords correspondants
            //initialiser et ajouter les panneaux aux bords correspondants
            initPanels();
            myViewContainer.add(titlePanel,BorderLayout.NORTH);
            myViewContainer.add(formPanel,BorderLayout.CENTER);
            myViewContainer.add(buttonsPannel,BorderLayout.SOUTH);

        }




        //initpanels
        private void initPanels(){
            initLabels();
            initTextFields();
            //-----------Panneau titre--------------

            titlePanel= new JPanel();
            //changer la couleur du fond de mon panneau
            titlePanel.setBackground(new Color(0,0,255));
            //ajouter un padding(10,0,10,0)
            titlePanel.setBorder(new EmptyBorder(10,0,10,0));
            //affecter un FlowLayout a notre titlePannel pour ajouter les elements sous forme d un flux horizontal
            titlePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
            //ajouter titre au centre
            titlePanel.add(lbl_title);
            //-----------Panneau formulaire--------------

            formPanel= new JPanel();
            //changer la couleur du fond de mon panneau
            formPanel.setBackground(new Color(255,255,255));
            formPanel.setLayout(new BorderLayout());
            formPanel.setBorder(new EmptyBorder(100,40,100,40));
            //ajouter un padding(10,0,10,0)
            //  titlePanel.setBorder(new EmptyBorder(10,0,10,0));
            JPanel westPannel=new JPanel();
            westPannel.setBackground(new Color(255,255,255));
            westPannel.setLayout(new GridLayout(8,1,5,5));
            westPannel.setBorder(new EmptyBorder(0,0,0,80));
            westPannel.add(lbl_login);
            westPannel.add(lbl_pass);
            westPannel.add(lbl_nom);
            westPannel.add(lbl_prenom);
            westPannel.add(lbl_cin);
            westPannel.add(lbl_email);
            westPannel.add(lbl_tel);
            westPannel.add(lbl_sexe);

            JPanel centerPannel=new JPanel();
            centerPannel.setBackground(new Color(255,255,255));
            centerPannel.setLayout(new GridLayout(8,1,5,5));
            centerPannel.add(txt_login);
            centerPannel.add(txt_pass);
            centerPannel.add(txt_nom);
            centerPannel.add(txt_prenom);
            centerPannel.add(txt_cin);
            centerPannel.add(txt_email);
            centerPannel.add(txt_tel);
            centerPannel.add(txt_sexe);

            formPanel.add(westPannel,BorderLayout.WEST);
            formPanel.add(centerPannel,BorderLayout.CENTER);




            //-----------Panneau buttons--------------
            initButtons();
            buttonsPannel= new JPanel();
            //changer la couleur du fond de mon panneau
            buttonsPannel.setBackground(new Color(0,0,255));
            //ajouter un padding(10,0,10,0)
            buttonsPannel.setBorder(new EmptyBorder(10,0,10,0));
            //affecter un flowLayout
            buttonsPannel.setLayout(new FlowLayout(FlowLayout.RIGHT));
            //ajouter titre au centre
            buttonsPannel.add(btn_add);
            buttonsPannel.add(btn_cancel);

        }
        //inittextfields

        private void initTextFields() {
            //---------------text login-------------
            //initialisation du label tTitre
            txt_login = new JTextField("");
            //personnalisation du label titre
            //modif de la police du texte
            txt_login.setFont(new Font("optima", Font.BOLD, 25));
            //modif de la couleur du texte
            txt_login.setForeground(new Color(0, 0, 0));
            //alignement du texte au label au centre
            txt_login.setHorizontalAlignment(JTextField.CENTER);
            //ajout icone
            //lbl_title.setIcon(new ImageIcon(""));

            //---------------text pass-------------
            //initialisation du label tTitre
            txt_pass = new JPasswordField("");
            //personnalisation du label titre
            //modif de la police du texte
            txt_pass.setFont(new Font("optima", Font.BOLD, 25));
            //modif de la couleur du texte
            txt_pass.setForeground(new Color(0, 0, 0));
            //alignement du texte au label au centre
            txt_pass.setHorizontalAlignment(JPasswordField.CENTER);
            //ajout icone
            //lbl_title.setIcon(new ImageIcon(""));


            //---------------text nom-------------
            //initialisation du label tTitre
            txt_nom = new JTextField("");
            //personnalisation du label titre
            //modif de la police du texte
            txt_nom.setFont(new Font("optima", Font.BOLD, 25));
            //modif de la couleur du texte
            txt_nom.setForeground(new Color(0, 0, 255));
            //alignement du texte au label au centre
            txt_nom.setHorizontalAlignment(JPasswordField.CENTER);
            //ajout icone
            //lbl_title.setIcon(new ImageIcon(""));


            //---------------text prenom-------------
            //initialisation du label tTitre
            txt_prenom = new JTextField("");
            //personnalisation du label titre
            //modif de la police du texte
            txt_prenom.setFont(new Font("optima", Font.BOLD, 25));
            //modif de la couleur du texte
            txt_prenom.setForeground(new Color(0, 0, 255));
            //alignement du texte au label au centre
            txt_prenom.setHorizontalAlignment(JPasswordField.CENTER);
            //ajout icone
            //lbl_title.setIcon(new ImageIcon(""));


            //---------------text cin-------------
            //initialisation du label tTitre
            txt_cin = new JTextField("");
            //personnalisation du label titre
            //modif de la police du texte
            txt_cin.setFont(new Font("optima", Font.BOLD, 25));
            //modif de la couleur du texte
            txt_cin.setForeground(new Color(0, 0, 255));
            //alignement du texte au label au centre
            txt_cin.setHorizontalAlignment(JPasswordField.CENTER);
            //ajout icone
            //lbl_title.setIcon(new ImageIcon(""));


            //---------------text email-------------
            //initialisation du label tTitre
            txt_email = new JTextField("");
            //personnalisation du label titre
            //modif de la police du texte
            txt_email.setFont(new Font("optima", Font.BOLD, 25));
            //modif de la couleur du texte
            txt_email.setForeground(new Color(0, 0, 255));
            //alignement du texte au label au centre
            txt_email.setHorizontalAlignment(JPasswordField.CENTER);
            //ajout icone
            //lbl_title.setIcon(new ImageIcon(""));

            //---------------text tel-------------
            //initialisation du label tTitre
            txt_tel = new JTextField("");
            //personnalisation du label titre
            //modif de la police du texte
            txt_tel.setFont(new Font("optima", Font.BOLD, 25));
            //modif de la couleur du texte
            txt_tel.setForeground(new Color(0, 0, 255));
            //alignement du texte au label au centre
            txt_tel.setHorizontalAlignment(JPasswordField.CENTER);
            //ajout icone
            //lbl_title.setIcon(new ImageIcon(""));

            //---------------text Sexe-------------
            //initialisation du label tTitre
            txt_sexe = new JTextField("");
            //personnalisation du label titre
            //modif de la police du texte
            txt_sexe.setFont(new Font("optima", Font.BOLD, 25));
            //modif de la couleur du texte
            txt_sexe.setForeground(new Color(0, 0, 255));
            //alignement du texte au label au centre
            txt_sexe.setHorizontalAlignment(JPasswordField.CENTER);
            //ajout icone
            //lbl_title.setIcon(new ImageIcon(""));

        }




        //initlabels
        public void initLabels(){
            //---------------Label Titre-------------
            //initialisation du label tTitre
            lbl_title = new JLabel("ADD Client");

            //personnalisation du label titre
            //modif de la police du texte
            lbl_title.setFont(new Font("optima", Font.BOLD, 30));
            //modif de la couleur du texte
            lbl_title.setForeground(new Color(0, 0, 0));
            //alignement du texte au label au centre
            lbl_title.setHorizontalAlignment(JLabel.CENTER);


            //---------------Label login-------------
            //initialisation du label tTitre
            lbl_login = new JLabel("Login");
            //cgpt
            ImageIcon icon = new ImageIcon("\\images\\icons\\usericon.png");
            lbl_login.setIcon(icon);
            //cgpt
            //personnalisation du label login
            //modif de la police du texte
            lbl_login.setFont(new Font("optima", Font.BOLD, 17));
            //modif de la couleur du texte
            lbl_login.setForeground(new Color(0, 0, 0));
            //alignement du texte au label au centre
            lbl_login.setHorizontalAlignment(JLabel.CENTER);
            //ajout icone
            //lbl_title.setIcon(new ImageIcon("usericon.png"));
            // }




            //---------------Label password-------------
            //initialisation du label tTitre
            lbl_pass = new JLabel("Password");
            //personnalisation du label titre
            //modif de la police du texte
            lbl_pass.setFont(new Font("optima", Font.BOLD, 17));
            //modif de la couleur du texte
            lbl_pass.setForeground(new Color(0, 0, 0));
            //alignement du texte au label au centre
            lbl_pass.setHorizontalAlignment(JLabel.CENTER);
            //ajout icone
            //lbl_pass.setIcon(new ImageIcon(""));


            //---------------Label nom-------------
            //initialisation du label tTitre
            lbl_nom = new JLabel("Nom");
            //personnalisation du label titre
            //modif de la police du texte
            lbl_nom.setFont(new Font("optima", Font.BOLD, 17));
            //modif de la couleur du texte
            lbl_nom.setForeground(new Color(0, 0, 0));
            //alignement du texte au label au centre
            lbl_nom.setHorizontalAlignment(JLabel.CENTER);
            //ajout icone
            //lbl_pass.setIcon(new ImageIcon(""));



            //---------------Label prenom-------------
            //initialisation du label tTitre
            lbl_prenom = new JLabel("Prenom");
            //personnalisation du label titre
            //modif de la police du texte
            lbl_prenom.setFont(new Font("optima", Font.BOLD, 17));
            //modif de la couleur du texte
            lbl_prenom.setForeground(new Color(0, 0, 0));
            //alignement du texte au label au centre
            lbl_prenom.setHorizontalAlignment(JLabel.CENTER);
            //ajout icone
            //lbl_pass.setIcon(new ImageIcon(""));



            //---------------Label cin-------------
            //initialisation du label tTitre
            lbl_cin = new JLabel("CIN");
            //personnalisation du label titre
            //modif de la police du texte
            lbl_cin.setFont(new Font("optima", Font.BOLD, 17));
            //modif de la couleur du texte
            lbl_cin.setForeground(new Color(0, 0, 0));
            //alignement du texte au label au centre
            lbl_cin.setHorizontalAlignment(JLabel.CENTER);
            //ajout icone
            //lbl_pass.setIcon(new ImageIcon(""));



            //---------------Label email-------------
            //initialisation du label tTitre
            lbl_email = new JLabel("Email");
            //personnalisation du label titre
            //modif de la police du texte
            lbl_email.setFont(new Font("optima", Font.BOLD, 17));
            //modif de la couleur du texte
            lbl_email.setForeground(new Color(0, 0, 0));
            //alignement du texte au label au centre
            lbl_email.setHorizontalAlignment(JLabel.CENTER);
            //ajout icone
            //lbl_pass.setIcon(new ImageIcon(""));


            //---------------Label tel-------------
            //initialisation du label tTitre
            lbl_tel = new JLabel("Telephone");
            //personnalisation du label titre
            //modif de la police du texte
            lbl_tel.setFont(new Font("optima", Font.BOLD, 17));
            //modif de la couleur du texte
            lbl_tel.setForeground(new Color(0, 0, 0));
            //alignement du texte au label au centre
            lbl_tel.setHorizontalAlignment(JLabel.CENTER);
            //ajout icone
            //lbl_pass.setIcon(new ImageIcon(""));


            //---------------Label sexe-------------
            //initialisation du label tTitre
            lbl_sexe = new JLabel("Sexe");
            //personnalisation du label titre
            //modif de la police du texte
            lbl_sexe.setFont(new Font("optima", Font.BOLD, 17));
            //modif de la couleur du texte
            lbl_sexe.setForeground(new Color(0, 0, 0));
            //alignement du texte au label au centre
            lbl_sexe.setHorizontalAlignment(JLabel.CENTER);
            //ajout icone
            //lbl_pass.setIcon(new ImageIcon(""));
        }

        //initbuttons
        private void initButtons(){

            //---------------btn add-------------
            //initialisation du bouton login
            initTextFields();
            btn_add= new JButton("Ajouter");
            //personnalisation du label titre
            //modif de la police du texte
            btn_add.setFont(new Font("optima",Font.BOLD,17));
            //modif de la couleur du texte
            btn_add.setForeground(new Color(0,0,0));
            //alignement du texte au label au centre
            btn_add.setHorizontalAlignment(JButton.CENTER);
            //ajout icone;
            //lbl_title.setIcon(new ImageIcon(""));
            btn_add.addActionListener(e -> {
                new ClientDao().save(new Client("client1","1234","benaouicha","haitam","cinClient","haitamben@gmail.com","06546512", Sexe.HOMME));
                this.setVisible(false);
            });


            //---------------btn cancel-------------
            //initialisation du bouton login
            btn_cancel= new JButton("Annuler");
            //personnalisation du label titre
            //modif de la police du texte
            btn_cancel.setFont(new Font("optima",Font.BOLD,17));
            //modif de la couleur du texte
            btn_cancel.setForeground(new Color(0,0,0));
            //alignement du texte au label au centre
            btn_cancel.setHorizontalAlignment(JButton.CENTER);
            btn_cancel.addActionListener(e -> {
                this.setVisible(false);
            });
        }


        public static void main(String[] args) {
            new Ajouter("AddClient");
        }



    }
