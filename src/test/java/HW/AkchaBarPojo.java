package HW;

public class AkchaBarPojo {
    private String date;
    private akchaBarRates rates;
    private float updated_at;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public akchaBarRates getRates() {
        return rates;
    }

    public void setRates(akchaBarRates rates) {
        this.rates = rates;
    }

    public float getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(float updated_at) {
        this.updated_at = updated_at;
    }
}
