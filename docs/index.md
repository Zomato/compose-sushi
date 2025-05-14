--- 
hide: -navigation -toc 
---

# Welcome to Sushi
Sushi is a sleek, modular Compose UI design system powering consistent user experiences across Zomato and its family of brands.

Currently available for 🤖 Android.

Will soon be available for 🖥️ Desktop, 🌐 Web (Js/WASM), 🍎 iOS, and any other platform Compose can run on.

_**Note: Currently Sushi is in alpha stage. APIs are subjected to change.**_ 

## Getting Started
For introduction and basic setup, click [here](introduction.md).
## Components

<style>
  img {
    border-radius: 20px;
  }
  .image-grid {
    margin-top: 80px;
    display: grid;
    grid-template-columns: 1fr 1fr 1fr;
    gap: 20px;
    text-align: center;
  }
  @media (max-width: 900px) {
    .image-grid {
      grid-template-columns: 1fr 1fr;
    }
  }

  @media (max-width: 600px) {
    .image-grid {
      grid-template-columns: 1fr;
    }
  }
</style>

<div class="image-grid">
    <div>
        <a href="sushitext">
          <img src="preview_text.png" alt="SushiText Preview">
        </a>
        <div>SushiText</div>
    </div>
    <div>
            <a href="sushiicon">
              <img src="preview_icon.png" alt="SushiIcon Preview">
            </a>
            <div>SushiIcon</div>
    </div>
    <div>
            <a href="sushibutton">
              <img src="preview_button.png" alt="SushiButton Preview">
            </a>
            <div>SushiButton</div>
    </div>
    <div>
            <a href="sushiimage">
              <img src="preview_image.png" alt="SushiImage Preview">
            </a>
            <div>SushiImage</div>
    </div>
    <div>
            <a href="sushicheckbox">
              <img src="preview_checkbox.png" alt="SushiCheckBox Preview">
            </a>
            <div>SushiCheckBox</div>
    </div>
    <div>
            <a href="sushiradiobutton">
              <img src="preview_radiobutton.png" alt="SushiRadioButton Preview">
            </a>
            <div>SushiRadioButton</div>
    </div>
    <div>
            <a href="sushiswitch">
              <img src="preview_switch.png" alt="SushiSwitch Preview">
            </a>
            <div>SushiSwitch</div>
    </div>
    <div>
            <a href="sushitag">
              <img src="preview_tag.png" alt="SushiTag Preview">
            </a>
            <div>SushiTag</div>
    </div>
    <div>
            <a href="sushitextfield">
              <img src="preview_textfield.png" alt="SushiTextField Preview">
            </a>
            <div>SushiTextField</div>
    </div>
    <div>
            <a href="sushianimation">
              <img src="preview_animation.png" alt="SushiAnimation Preview">
            </a>
            <div>SushiAnimation</div>
    </div>
    <div>
            <a href="sushiloader">
              <img src="preview_loader.png" alt="SushiLoader Preview">
            </a>
            <div>SushiLoader</div>
    </div>
    <div>
            <a href="sushicard">
              <img src="preview_card.png" alt="SushiCard Preview">
            </a>
            <div>SushiCard</div>
    </div>
    <div>
            <a href="sushiindicator">
              <img src="preview_indicators.png" alt="SushiIndicators Preview">
            </a>
            <div>SushiIndicators</div>
    </div>
    <div>
            <a href="sushidivider">
              <img src="preview_divider.png" alt="SushiDivider Preview">
            </a>
            <div>SushiDivider</div>
    </div>
    <div>
            <a href="sushishimmer">
              <img src="preview_shimmer.png" alt="SushiShimmer Preview">
            </a>
            <div>SushiShimmer</div>
    </div>
    <div>
            <a href="sushisnackbar">
              <img src="preview_snackbar.png" alt="SushiSnackbar Preview">
            </a>
            <div>SushiSnackbar</div>
    </div>
    <div>
            <a href="sushibottomsheet">
              <img src="preview_bottom_sheet.png" alt="SushiBottomSheet Preview">
            </a>
            <div>SushiBottomSheet</div>
    </div>
    <div>
            <a href="sushidialog">
              <img src="preview_dialog.png" alt="SushiDialog Preview">
            </a>
            <div>SushiDialog</div>
    </div>
    <div>
            <a href="sushidropdown">
              <img src="preview_dropdown.png" alt="SushiDropDown Preview">
            </a>
            <div>SushiDropDown</div>
    </div>
    <div>
            <a href="sushimedia">
              <img src="preview_media.png" alt="SushiMedia Preview">
            </a>
            <div>SushiMedia</div>
    </div>
    <div>
            <a href="sushiotpinput">
              <img src="preview_otp_input.png" alt="SushiOTPInput Preview">
            </a>
            <div>SushiOTPInput</div>
    </div>
    <div>
            <a href="sushihorizontalpager">
              <img src="preview_horizontal_pager.png" alt="SushiHorizontalPager Preview">
            </a>
            <div>SushiHorizontalPager</div>
    </div>
    <div>
            <a href="sushiverticalpager">
              <img src="preview_vertical_pager.png" alt="SushiVerticalPager Preview">
            </a>
            <div>SushiVerticalPager</div>
    </div>
    <div>
            <a href="sushiratingbar">
              <img src="preview_ratingbar.png" alt="SushiRatingBar Preview">
            </a>
            <div>SushiRatingBar</div>
    </div>
    <div>
            <a href="sushitooltip">
              <img src="preview_tooltip.png" alt="SushiTooltip Preview">
            </a>
            <div>SushiTooltip</div>
    </div>
    <div>
            <a href="sushiviewflipper">
              <img src="preview_view_flipper.png" alt="SushiViewFlipper Preview">
            </a>
            <div>SushiViewFlipper</div>
    </div>
</div>

<br>
# Special Thanks
- Thanks to [Compose Material](https://developer.android.com/jetpack/androidx/releases/compose-material) upon which this library is based.
- Thanks to [Lumo UI](https://github.com/nomanr/lumo-ui) for implementation references.
- Thanks to [Compose Unstyled](https://github.com/composablehorizons/compose-unstyled) and [Material for MkDocs](https://squidfunk.github.io/mkdocs-material/) for the documentation site.