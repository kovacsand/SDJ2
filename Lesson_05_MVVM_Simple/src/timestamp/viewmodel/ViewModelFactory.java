package timestamp.viewmodel;

import timestamp.model.ModelFactory;

public class ViewModelFactory {

    private TimestampViewModel timestampViewModel;

    public ViewModelFactory(ModelFactory modelFactory) {
        timestampViewModel = new TimestampViewModel(modelFactory.getDataModel());
    }

    public TimestampViewModel getTimestampViewModel() {
        return timestampViewModel;
    }
}
