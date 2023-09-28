package com.example.wordscramble;

public class Menu {
    public Menu() {
    }

    public Difficulties displayDifficultyMenu(StringBuilder menu) {
        int i = 0;
        for (Difficulties op :Difficulties.values()  ) {
            menu.append(op.toString()).append("\n");
        }
        System.out.println(menu.toString());

        int returnedValue = HelloApplication.m_scanInput.nextInt();

        HelloApplication.m_scanInput.nextLine();
        return Difficulties.valueOf(returnedValue);
    }
}
