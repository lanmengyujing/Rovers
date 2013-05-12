
public class MarRovers {

    private String position;
    private int posX;
    private int posY;
    private char direction;

    public void setInstruction(String instruction) {
        String[] instructions = instruction.split(" ");
        posX = Integer.valueOf(instructions[0]);
        posY = Integer.valueOf(instructions[1]);
        direction = instructions[2].charAt(0);
    }

    public void executeInstruction(String commandStr) {
        commandStr = commandStr.toUpperCase();
        char command = commandStr.charAt(0);
        if(command =='M'){
            posY+=1;
        }
        else if(command == 'R'){
            direction = 'E';
        }
        else {
            direction = 'W';
        }


    }
    public String getOutput() {
        return ""+posX +" "+ posY + " " +direction;
    }

    public void setPlateau(String plateau) {

    }
}
