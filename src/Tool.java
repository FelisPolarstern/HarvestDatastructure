public enum Tool {
    WATERINGCAN("Wateringcan", 20.0),
    FERTILISER("Fertiliser", 5.00);

    private final String toolType;
    private final double toolCost;

    Tool(String toolType, double toolCost){
        this.toolType = toolType;
        this.toolCost = toolCost;
    }
    public double getToolCost(){
        return this.toolCost;
    }

}
