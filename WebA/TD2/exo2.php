<?php
class Client 
{
    public $numero;
    public $nom;
    public $prenom;
    public $tel;

    public function __construct($numero, $nom, $prenom, $tel)
    {
        $this->numero=$numero;
        $this->nom=$nom;
        $this->prenom=$prenom;
        $this->tel=$tel;
    }

    public function afficher()
    {
        echo "<br>Numero : ".$this->numero;
        echo "<br>Nom : ".$this->nom;
        echo "<br>Prenom : ".$this->prenom;
        echo "<br>Tel : ".$this->tel;
    }

    public function maj($numero, $nom, $prenom, $tel)
    {
        try {
            $conn = new PDO("mysql:host=$servername;dbname=$dbname", $username, $password);
            $conn->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

            $sql= "UPDATE client SET nom = ?,prenom = ?,tel = ? WHERE numero =?";
            $stmt = $conn->prepare($sql);          
            $stmt->execute();

            echo $stmt->rowCount() . " records UPDATED successfully";
          } catch(PDOException $e) {
            echo $sql . "<br>" . $e->getMessage();
          }
          $conn = null;
    }
}

class Compte
{
    public $numero;
    public $solde;
    public $numero_client;

    public function __construct($numero, $solde, $numero_client)
    {
        $this->numero=$numero;
        $this->solde=$solde;
        $this->numero_client=$numero_client;
    }
}

?>