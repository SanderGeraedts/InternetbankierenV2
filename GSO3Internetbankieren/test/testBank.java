/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import bank.bankieren.Bank;
import bank.centraleBank.CentraleBank;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sander Geraedts - Code Panda
 */
public class testBank {
    
    private Bank bank;
    
    public testBank() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        bank = new Bank("Rabobank", new CentraleBank());        
    }
    
    @After
    public void tearDown() {
    }
    
    /**
     * creatie van een nieuwe bankrekening met een identificerend rekeningnummer; 
     * alleen als de klant, geidentificeerd door naam en plaats, nog niet bestaat 
     * wordt er ook een nieuwe klant aangemaakt
     * 
     * @param naam
     *            van de eigenaar van de nieuwe bankrekening
     * @param plaats
     *            de woonplaats van de eigenaar van de nieuwe bankrekening
     * @return -1 zodra naam of plaats een lege string en anders het nummer van de
     *         gecreeerde bankrekening
     */
    @Test
    public void testOpenRekening(){
        String naam = "Jan Klaas";
        String plaats = "Eindhoven";
        
        Boolean passed = false;
        
        int result = bank.openRekening(naam, plaats);
        
        if(result != -1){
            passed = true;
        }
        
        assertTrue(passed);
    }
    
//    @Test
//    public void testOpenRekeningSameCredentials(){
//        String naam = "Jan Klaas";
//        String plaats = "Eindhoven";
//        
//        Boolean passed = false;
//        
//        int result = bank.openRekening(naam, plaats);
//        
//        if(result == -1){
//            fail();
//        }
//        
//        result = bank.openRekening(naam, plaats);
//        
//        if(result != -1){
//            passed = true;
//        }
//        
//        assertTrue(passed);
//    }
    
    @Test
    public void testOpenRekeningEmptyNaam(){
        String naam = "";
        String plaats = "Eindhoven";
        
        Boolean passed = false;
        
        int result = bank.openRekening(naam, plaats);
        
        if(result == -1){
            passed = true;
        }
        
        assertTrue(passed);
    }
    
    @Test
    public void testOpenRekeningEmptyPlaats(){
        String naam = "Jan Klaas";
        String plaats = "";
        
        Boolean passed = false;
        
        int result = bank.openRekening(naam, plaats);
        
        if(result == -1){
            passed = true;
        }
        
        assertTrue(passed);
    }
}
