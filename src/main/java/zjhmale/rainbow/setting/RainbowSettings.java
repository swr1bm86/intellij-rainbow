package zjhmale.rainbow.setting;

import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.intellij.util.xmlb.XmlSerializerUtil;
import org.jetbrains.annotations.Nullable;

/**
 * Created by zjh on 2016/2/16.
 */

@State(name = "RainbowSettings", storages = {
        @Storage("$APP_CONFIG$/rainbow_application.xml")
})
public class RainbowSettings implements PersistentStateComponent<RainbowSettings> {
    public boolean isRainbowIdentifier = true;
    public boolean isRainbowDelimiter = true;

    @Nullable
    @Override
    public RainbowSettings getState() {
        return this;
    }

    @Override
    public void loadState(RainbowSettings state) {
        XmlSerializerUtil.copyBean(state, this);
    }

    public static RainbowSettings getInstance() {
        return ServiceManager.getService(RainbowSettings.class);
    }
}
