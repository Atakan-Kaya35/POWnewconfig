package org.example.powwww.med;
import java.io.*;
import java.util.*;
import java.io.File;

public class Pill extends Medicine {

    public static double[] prices = {9.5,10,17.25,20.5,12.5,7,8.5,17,18.75,19.25,8,11.25,14,15.75,
    16.5,18,21.5,24.75,16,21.5,11.25,6,5.25,13.5,12};
    public static ArrayList<String[]> AllPills = new ArrayList();
    public static ArrayList<String[]> OTCpills = new ArrayList();
    public static ArrayList<String[]> prescribedPills = new ArrayList();
    public static ArrayList<Pill> pills = new ArrayList();

    public int pillID;
    static int IDsoFar = 0;

    public Pill(int IDnumber) {
        super(AllPills.get(IDnumber)[0], AllPills.get(IDnumber)[3]);
        this.pillID = IDnumber;
        this.cyclesLeft = 5;
        this.setPrice(5);
    }

    public Pill(int IDnumber, double price) {
        super(AllPills.get(IDnumber)[0], AllPills.get(IDnumber)[3]);
        this.pillID = IDnumber;
        this.cyclesLeft = 5;
        this.setPrice(price);
    }

    public Pill(int IDnumber, String name) {
        super(name, AllPills.get(IDnumber)[3]);
        this.pillID = IDnumber;
        this.cyclesLeft = 5;
        this.setPrice(5);
    }

    public Pill(int IDnumber, int cyclesOfTaking, boolean[] takeingFrequency) {
        super(AllPills.get(IDnumber)[0], AllPills.get(IDnumber)[1]);
        this.pillID = IDnumber;
        super.setCyclesOfTaking(cyclesOfTaking);
        super.setConsumeFreq(takeingFrequency);
        this.setPrice(5);
    }
    public Pill(int IDnumber, int cyclesOfTaking, boolean[] takeingFrequency, String name, String description) {
        super();
        this.pillID = IDnumber;
        super.setCyclesOfTaking(cyclesOfTaking);
        super.setConsumeFreq(takeingFrequency);
    }

    public static ArrayList<Pill> getPillObjects() {
        ArrayList<Pill> pills = new ArrayList<>();
        int ID = 0;
        Random random = new Random();
        // Adding pill information
        String[] pillsText = {
                // Provided pill information
                // "PillName,CyclesOfTaking,TakingFrequency,Description"
                "Amoxicillin,7,true,true,Antibiotic used to treat bacterial infections such as pneumonia bronchitis and infections of the ear nose throat skin or urinary tract",
                "Albuterol,5,true,false,Bronchodilator used to treat asthma chronic obstructive pulmonary disease (COPD) and other breathing problems",
                "Diazepam,6,true,true,Benzodiazepine used to treat anxiety disorders alcohol withdrawal muscle spasms and seizures",
                "Ciprofloxacin,7,true,false,Fluoroquinolone antibiotic used to treat bacterial infections such as urinary tract infections respiratory infections skin infections and bone/joint infections",
                "Prednisone,5,false,false,Corticosteroid used to treat inflammatory conditions such as arthritis asthma skin conditions and allergic disorders",
                // Add more pills as needed...
                "Metronidazole,6,true,false,Nitroimidazole antibiotic used to treat bacterial infections protozoal infections and infections of the vagina stomach skin joints and respiratory tract",
                "Azithromycin,7,false,true,Macrolide antibiotic used to treat bacterial infections such as respiratory infections skin infections ear infections and sexually transmitted infections",
                "Warfarin,4,true,false,Oral anticoagulant used to prevent blood clots in conditions such as atrial fibrillation deep vein thrombosis (DVT) and pulmonary embolism",
                "Clopidogrel,5,false,true,Antiplatelet medication used to reduce the risk of heart attack and stroke in conditions such as acute coronary syndrome peripheral artery disease and after a recent heart attack or stroke",
                "Levofloxacin,6,false,false,Fluoroquinolone antibiotic used to treat bacterial infections such as respiratory infections skin infections urinary tract infections and prostate infections",
                "Cephalexin,7,true,true,Cephalosporin antibiotic used to treat bacterial infections such as respiratory tract infections skin infections ear infections and urinary tract infections",
                "Naproxen,6,false,false,Nonsteroidal anti-inflammatory drug (NSAID) used to reduce pain inflammation and fever",
                "Fluconazole,7,true,true,Antifungal medication used to treat fungal infections such as yeast infections of the mouth throat esophagus abdomen lungs blood and other organs",
                "Hydrocodone,5,false,false,Opioid analgesic used to treat moderate to severe pain",
                "Oxycodone,4,true,true,Opioid analgesic used to treat moderate to severe pain",
                "Alprazolam,6,false,false,Benzodiazepine used to treat anxiety and panic disorders",
                "Tramadol,7,true,true,Opioid analgesic used to treat moderate to severe pain",
                "Doxycycline,5,false,true,Tetracycline antibiotic used to treat bacterial infections such as acne urinary tract infections and chlamydia",
                "Lorazepam,6,false,false,Benzodiazepine used to treat anxiety disorders insomnia and seizures",
                "Furosemide,7,true,true,Loop diuretic used to treat fluid retention (edema) and high blood pressure",
                "Omeprazole,5,false,false,Proton pump inhibitor (PPI) used to reduce stomach acid and treat conditions like heartburn acid reflux and ulcers",
                "Simvastatin,6,false,true,Statin medication used to lower cholesterol levels in the blood and reduce the risk of heart disease and stroke",
                "Metformin,7,true,false,Oral diabetes medicine used to control blood sugar levels in people with type 2 diabetes",
                "Lisinopril,4,true,true,Angiotensin-converting enzyme (ACE) inhibitor used to treat high blood pressure heart failure and to improve survival after a heart attack",
                "Atorvastatin,5,false,false,Statin medication used to lower cholesterol levels in the blood and reduce the risk of heart disease and stroke"
        };

        // Take the first 25 pills from the provided list
        for (int i = 0; i < 25 && i < pillsText.length; i++) {
            String[] pillInfo = pillsText[i].split(",");
            String name = pillInfo[0];
            String description = pillInfo[4];

            // Generate random cycles of taking between 3 and 7
            int cyclesOfTaking = random.nextInt(5) + 3;

            // Generate random taking frequency
            boolean[] frequency = new boolean[3];
            for (int j = 0; j < 3; j++) {
                frequency[j] = random.nextBoolean();
            }

            Pill pill = new Pill(ID, cyclesOfTaking, frequency, name, description);
            pills.add(pill);
            pill.setPrice(prices[i]);
            ID++;
        }
        return pills;
    }




    public static void fillPills() {
        // Get the file path relative to the current package
        /* String counterMeds = "C:\\Users\\ataka\\Desktop\\POWnewconfig\\powwww\\src\\main\\java\\org\\example\\powwww\\med\\over_the_counter_meds.txt";
        String prescribedMeds = "C:\\Users\\ataka\\Desktop\\POWnewconfig\\powwww\\src\\main\\java\\org\\example\\powwww\\med\\prescribed_meds.csv";

        // Use ClassLoader to load the file
        //try (Scanner scanner = new Scanner(new File(counterMeds))) {

            while (scanner.hasNextLine()) {
                String[] command = scanner.nextLine().split(",");
                AllPills.add(command);
                OTCpills.add(command);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (Scanner scanner = new Scanner(new File(prescribedMeds))) {

            while (scanner.hasNextLine()) {
                String[] command = scanner.nextLine().split(",");
                AllPills.add(command);
                prescribedPills.add(command);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println();*/
        // Adding pill information
        String[] a = {"Paracetamol", "Acute", "No", "A common pain reliever and fever reducer"};
        AllPills.add(a);

        String[] b = {"Ibuprofen", "Acute", "No", "Nonsteroidal anti-inflammatory drug (NSAID) used to reduce pain"};
        AllPills.add(b);

        String[] c = {"Aspirin", "Acute/Periodic", "No", "NSAID used to treat pain fever and inflammation. It is also used to prevent blood clots and reduce the risk of heart attack and stroke"};
        AllPills.add(c);

        String[] d = {"Loratadine", "Periodic", "No", "Antihistamine used to treat symptoms of allergies such as sneezing"};
        AllPills.add(d);

        String[] e = {"Cetirizine", "Periodic", "No", "Antihistamine used to treat symptoms of seasonal allergies such as sneezing"};
        AllPills.add(e);

        // Additional pill information
        String[] f = {"Amoxicillin", "Acute", "Yes", "Antibiotic used to treat bacterial infections such as pneumonia bronchitis and infections of the ear nose throat skin or urinary tract"};
        AllPills.add(f);

        String[] g = {"Albuterol", "Acute", "Yes", "Bronchodilator used to treat asthma chronic obstructive pulmonary disease (COPD) and other breathing problems"};
        AllPills.add(g);

        String[] h = {"Diazepam", "Acute", "Yes", "Benzodiazepine used to treat anxiety disorders alcohol withdrawal muscle spasms and seizures"};
        AllPills.add(h);

        String[] i = {"Ciprofloxacin", "Acute", "Yes", "Fluoroquinolone antibiotic used to treat bacterial infections such as urinary tract infections respiratory infections skin infections and bone/joint infections"};
        AllPills.add(i);

        String[] j = {"Prednisone", "Acute", "Yes", "Corticosteroid used to treat inflammatory conditions such as arthritis asthma skin conditions and allergic disorders"};
        AllPills.add(j);

        String[] k = {"Metronidazole", "Acute", "Yes", "Nitroimidazole antibiotic used to treat bacterial infections protozoal infections and infections of the vagina stomach skin joints and respiratory tract"};
        AllPills.add(k);

        String[] l = {"Azithromycin", "Acute", "Yes", "Macrolide antibiotic used to treat bacterial infections such as respiratory infections skin infections ear infections and sexually transmitted infections"};
        AllPills.add(l);

        String[] m = {"Warfarin", "Acute", "Yes", "Oral anticoagulant used to prevent blood clots in conditions such as atrial fibrillation deep vein thrombosis (DVT) and pulmonary embolism"};
        AllPills.add(m);

        String[] n = {"Clopidogrel", "Acute", "Yes", "Antiplatelet medication used to reduce the risk of heart attack and stroke in conditions such as acute coronary syndrome peripheral artery disease and after a recent heart attack or stroke"};
        AllPills.add(n);

        String[] o = {"Levofloxacin", "Acute", "Yes", "Fluoroquinolone antibiotic used to treat bacterial infections such as respiratory infections skin infections urinary tract infections and prostate infections"};
        AllPills.add(o);

        String[] p = {"Cephalexin", "Acute", "Yes", "Cephalosporin antibiotic used to treat bacterial infections such as respiratory tract infections skin infections ear infections and urinary tract infections"};
        AllPills.add(p);

        String[] q = {"Naproxen", "Acute", "Yes", "Nonsteroidal anti-inflammatory drug (NSAID) used to reduce pain inflammation and fever"};
        AllPills.add(q);

        String[] r = {"Fluconazole", "Acute", "Yes", "Antifungal medication used to treat fungal infections such as yeast infections of the mouth throat esophagus abdomen lungs blood and other organs"};
        AllPills.add(r);

        String[] s = {"Hydrocodone", "Acute", "Yes", "Opioid analgesic used to treat moderate to severe pain"};
        AllPills.add(s);

        String[] t = {"Oxycodone", "Acute", "Yes", "Opioid analgesic used to treat moderate to severe pain"};
        AllPills.add(t);

        String[] u = {"Alprazolam", "Acute", "Yes", "Benzodiazepine used to treat anxiety and panic disorders"};
        AllPills.add(u);

        String[] v = {"Tramadol", "Acute", "Yes", "Opioid analgesic used to treat moderate to severe pain"};
        AllPills.add(v);

        String[] w = {"Doxycycline", "Acute", "Yes", "Tetracycline antibiotic used to treat bacterial infections such as acne urinary tract infections and chlamydia"};
        AllPills.add(w);

        String[] x = {"Lorazepam", "Acute", "Yes", "Benzodiazepine used to treat anxiety disorders insomnia and seizures"};
        AllPills.add(x);

        String[] y = {"Furosemide", "Acute", "Yes", "Loop diuretic used to treat fluid retention (edema) and high blood pressure"};
        AllPills.add(y);

        String[] z = {"Omeprazole", "Periodic", "Yes", "Proton pump inhibitor (PPI) used to reduce stomach acid and treat conditions like heartburn acid reflux and ulcers"};
        AllPills.add(z);

        String[] aa = {"Simvastatin", "Periodic", "Yes", "Statin medication used to lower cholesterol levels in the blood and reduce the risk of heart disease and stroke"};
        AllPills.add(aa);

        String[] ab = {"Metformin", "Periodic", "Yes", "Oral diabetes medicine used to control blood sugar levels in people with type 2 diabetes"};
        AllPills.add(ab);

        String[] ac = {"Lisinopril", "Periodic", "Yes", "Angiotensin-converting enzyme (ACE) inhibitor used to treat high blood pressure heart failure and to improve survival after a heart attack"};
        AllPills.add(ac);

        String[] ad = {"Atorvastatin", "Periodic", "Yes", "Statin medication used to lower cholesterol levels in the blood and reduce the risk of heart disease and stroke"};
        AllPills.add(ad);

        String[] ae = {"Metoprolol", "Periodic", "Yes", "Beta-blocker used to treat high blood pressure chest pain (angina) heart failure and to improve survival after a heart attack"};
        AllPills.add(ae);

        String[] af = {"Levothyroxine", "Periodic", "Yes", "Thyroid hormone used to treat an underactive thyroid (hypothyroidism)"};
        AllPills.add(af);

        String[] ag = {"Losartan", "Periodic", "Yes", "Angiotensin II receptor blocker (ARB) used to treat high blood pressure and to reduce the risk of stroke in patients with hypertension and left ventricular hypertrophy"};
        AllPills.add(ag);

        String[] ah = {"Amlodipine", "Periodic", "Yes", "Calcium channel blocker used to treat high blood pressure and chest pain (angina)"};
        AllPills.add(ah);

        String[] ai = {"Montelukast", "Periodic", "Yes", "Leukotriene receptor antagonist used to prevent asthma and to treat seasonal allergies"};
        AllPills.add(ai);

        String[] aj = {"Fluticasone", "Periodic", "Yes", "Corticosteroid used to treat asthma allergic rhinitis and nasal polyps"};
        AllPills.add(aj);

        String[] ak = {"Ranitidine", "Periodic", "Yes", "H2 blocker used to reduce stomach acid and treat conditions like heartburn acid reflux and ulcers"};
        AllPills.add(ak);

        String[] al = {"Pantoprazole", "Periodic", "Yes", "Proton pump inhibitor (PPI) used to reduce stomach acid and treat conditions like heartburn acid reflux and ulcers"};
        AllPills.add(al);

        String[] am = {"Celecoxib", "Periodic", "Yes", "NSAID used to treat pain inflammation and stiffness caused by arthritis"};
        AllPills.add(am);

        String[] an = {"Meloxicam", "Periodic", "Yes", "NSAID used to treat pain inflammation and stiffness caused by arthritis"};
        AllPills.add(an);

        String[] ao = {"Budesonide", "Periodic", "Yes", "Corticosteroid used to treat asthma allergic rhinitis and inflammatory bowel disease"};
        AllPills.add(ao);

        String[] ap = {"Eszopiclone", "Periodic", "Yes", "Nonbenzodiazepine sedative-hypnotic used to treat insomnia"};
        AllPills.add(ap);

        String[] aq = {"Fluoxetine", "Periodic", "Yes", "Selective serotonin reuptake inhibitor (SSRI) used to treat depression obsessive-compulsive disorder (OCD) bulimia nervosa and panic disorder"};
        AllPills.add(aq);

        String[] ar = {"Gabapentin", "Periodic", "Yes", "Anticonvulsant medication used to treat epilepsy and neuropathic pain"};
        AllPills.add(ar);

        String[] as = {"Hydrochlorothiazide", "Periodic", "Yes", "Thiazide diuretic used to treat high blood pressure and fluid retention (edema) caused by various conditions"};
        AllPills.add(as);

        String[] at = {"Insulin", "Acute/Periodic", "Yes", "Hormone used to treat diabetes by controlling blood sugar levels"};
        AllPills.add(at);

        String[] au = {"Aripiprazole", "Periodic", "Yes", "Atypical antipsychotic used to treat schizophrenia bipolar disorder major depressive disorder and irritability associated with autism"};
        AllPills.add(au);

        String[] av = {"Tadalafil", "Acute", "Yes", "Phosphodiesterase type 5 (PDE5) inhibitor used to treat erectile dysfunction (impotence) and symptoms of benign prostatic hyperplasia (enlarged prostate)"};
        AllPills.add(av);

        String[] aw = {"Sildenafil", "Acute", "Yes", "Phosphodiesterase type 5 (PDE5) inhibitor used to treat erectile dysfunction (impotence) and pulmonary arterial hypertension"};
        AllPills.add(aw);

        String[] ax = {"Citalopram", "Periodic", "Yes", "Selective serotonin reuptake inhibitor (SSRI) used to treat depression and anxiety disorders"};
        AllPills.add(ax);

        String[] ay = {"Carvedilol", "Periodic", "Yes", "Beta-blocker used to treat high blood pressure heart failure and to improve survival after a heart attack"};
        AllPills.add(ay);*/
    }



    // bütün pilleri obje olarak oluşturup bir arrayliste ekledik. buradan seçmek daha kolay olur simde ayrıca gui için bize
    // böylesi gerekli.



            // Generate random cycles of taking between 3 and 7
            int cyclesOfTaking = random.nextInt(5) + 3;

            // Generate random taking frequency
            boolean[] frequency = new boolean[3];
            for (int i = 0; i < 3; i++) {
                frequency[i] = random.nextBoolean();
            }

            Pill pill = new Pill(IDsoFar, cyclesOfTaking, frequency);

            allRealPills.add(pill);

            AllPills.add(pillInfo);
            IDsoFar++;
        }
    }
    

    public int getPillID() {
        return pillID;
    }

    public void setPillID(int pillID) {
        this.pillID = pillID;
    }

    public static ArrayList<String[]> getAllPills(){
        return AllPills;
    }
}


