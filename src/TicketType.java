enum TicketType {

    PREMIUM{
        @Override
        public int calculateMoney(int amount){
            return amount+amount/2;
        }
    },
    GENERAL{
        @Override
        public int calculateMoney(int amount){
            return amount;
        }
    };
    abstract int calculateMoney(int amount);
}
