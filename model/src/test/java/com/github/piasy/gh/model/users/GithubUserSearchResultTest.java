package com.github.piasy.gh.model.users;

import com.github.piasy.base.model.provider.GsonProviderExposure;
import com.github.piasy.test.mock.MockProvider;
import com.github.piasy.test.rules.ThreeTenBPRule;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import junit.framework.Assert;
import org.json.JSONException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

/**
 * Created by Piasy{github.com/Piasy} on 15/8/11.
 */
public class GithubUserSearchResultTest {

    @Rule
    public ThreeTenBPRule mThreeTenBPRule = ThreeTenBPRule.junitTest();

    private Gson mGson;

    @Before
    public void setUp() {
        mGson = GsonProviderExposure.exposeGson();
    }

    @Test
    public void testSerialize() {
        final GithubUserSearchResult converted =
                mGson.fromJson(MockProvider.provideSimplifiedGithubUserSearchResultStr(),
                        new TypeToken<GithubUserSearchResult>() {
                        }.getType());
        try {
            JSONAssert.assertEquals(MockProvider.provideSimplifiedGithubUserSearchResultStr(),
                    mGson.toJson(converted), false);
            Assert.assertTrue(true);
        } catch (JSONException e) {
            Assert.assertTrue(false);
        }
    }
}
