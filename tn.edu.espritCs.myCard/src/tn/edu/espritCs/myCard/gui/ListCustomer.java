package tn.edu.espritCs.myCard.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import tn.edu.espritCs.myCard.services.ModelListCustomer;

public class ListCustomer extends JFrame 
{
	private ModelListCustomer modelListCustomer = new ModelListCustomer();
    private JTable tableCustomer;

    public ListCustomer()
    {
        super();
        
        setTitle("Show all Customer");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        tableCustomer = new JTable(modelListCustomer);
        getContentPane().add(new JScrollPane(tableCustomer), BorderLayout.CENTER);
        JPanel boutons = new JPanel();
        boutons.add(new JButton(new RemoveAction()));
        getContentPane().add(boutons, BorderLayout.SOUTH);
        pack();
    }
 
    public static void main(String[] args)
    {
        new ListCustomer().setVisible(true);
    }

    private class RemoveAction extends AbstractAction
    {
        private RemoveAction() 
        {
            super("Delete");
        }
 
        public void actionPerformed(ActionEvent e) {
            int[] selection = tableCustomer.getSelectedRows();
            
            for(int i = selection.length - 1; i >= 0; i--)
            {
            	modelListCustomer.removeCustomer(selection[i]);
            }
  
        }
    }
}
