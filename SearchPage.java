import java.awt.event.*;
import javax.swing.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class SearchPage extends JFrame implements ActionListener{

    JTextField numTF, nameTF;
    JButton searchBtn;

    SearchPage(){
        setTitle("Student Registration Form");
        setSize(700, 700);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    };

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == searchBtn){
            // String num = numTF.getText();
            String name = nameTF.getText();
            
            File dirPath = new File(".");
            File filesList[] = dirPath.listFiles((d, fname) -> fname.endsWith(".txt")); 
            // ^ java Lambda func. Similar to JS ES6 anonymous arrow funcs

            String searchTerm = name;

            ArrayList<String> dataList = new ArrayList<String>();
            
            for(File fileName: filesList){
                // String fName = fileName.getName();
                try {
                    // File file = new File(fName);
                    Scanner fsc = new Scanner(fileName);
                    // int counter = 0;
                    String data = "";
                    // System.out.println(file.exists());
                    while(fsc.hasNextLine()){
                        data = data.concat("\n"+fsc.nextLine());
                    }
                    if(data.contains(searchTerm)){
                        // System.out.println(data);
                        dataList.add(data);
                    }
                    fsc.close();
                } catch (Exception err) {
                    System.out.println(err);
                }
            }

            // TODO:Handle these in GUI as well
            if (dataList.isEmpty()) {
                System.out.println("No User Found with Specified name");
            } else {
                System.out.println(dataList);
            }
        }
    }

    public static void main(String[] args) {
        new SearchPage();
    }
}
