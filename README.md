![Server Sided Portals banner](https://raw.githubusercontent.com/crystal-nest/mod-fancy-assets/main/server-sided-portals/banner.png "Server Sided Portals banner")

---

![Minecraft](https://raw.githubusercontent.com/crystal-nest/mod-fancy-assets/main/minecraft/minecraft.svg "Minecraft")[![1.21.5](https://raw.githubusercontent.com/crystal-nest/mod-fancy-assets/main/minecraft/1-21-5.svg)](https://www.patreon.com/c/crystalspider/membership)![Separator](https://raw.githubusercontent.com/crystal-nest/mod-fancy-assets/main/separator.svg)[![1.21.4](https://raw.githubusercontent.com/crystal-nest/mod-fancy-assets/main/minecraft/1-21-4.svg "1.21.4")](https://modrinth.com/mod/server-sided-portals/versions?g=1.21.3)![Separator](https://raw.githubusercontent.com/crystal-nest/mod-fancy-assets/main/separator.svg)[![1.21.3](https://raw.githubusercontent.com/crystal-nest/mod-fancy-assets/main/minecraft/1-21-3.svg "1.21.3")](https://modrinth.com/mod/server-sided-portals/versions?g=1.21.3)![Separator](https://raw.githubusercontent.com/crystal-nest/mod-fancy-assets/main/separator.svg)[![1.21.1](https://raw.githubusercontent.com/crystal-nest/mod-fancy-assets/main/minecraft/1-21-1.svg "1.21.1")](https://modrinth.com/mod/server-sided-portals/versions?g=1.21.1)![Separator](https://raw.githubusercontent.com/crystal-nest/mod-fancy-assets/main/separator.svg)[![1.21](https://raw.githubusercontent.com/crystal-nest/mod-fancy-assets/main/minecraft/1-21.svg "1.21")](https://modrinth.com/mod/server-sided-portals/versions?g=1.21)![Separator](https://raw.githubusercontent.com/crystal-nest/mod-fancy-assets/main/separator.svg)[![1.20.4](https://raw.githubusercontent.com/crystal-nest/mod-fancy-assets/main/minecraft/1-20-4.svg "1.20.4")](https://modrinth.com/mod/server-sided-portals/versions?g=1.20.4)![Separator](https://raw.githubusercontent.com/crystal-nest/mod-fancy-assets/main/separator.svg)[![1.20.2](https://raw.githubusercontent.com/crystal-nest/mod-fancy-assets/main/minecraft/1-20-2.svg "1.20.2")](https://modrinth.com/mod/server-sided-portals/versions?g=1.20.2)![Separator](https://raw.githubusercontent.com/crystal-nest/mod-fancy-assets/main/separator.svg)[![1.20.1](https://raw.githubusercontent.com/crystal-nest/mod-fancy-assets/main/minecraft/1-20-1.svg "1.20.1")](https://modrinth.com/mod/server-sided-portals/versions?g=1.20.1)![Separator](https://raw.githubusercontent.com/crystal-nest/mod-fancy-assets/main/separator.svg)[![1.19.4](https://raw.githubusercontent.com/crystal-nest/mod-fancy-assets/main/minecraft/1-19-4.svg "1.19.4")](https://modrinth.com/mod/server-sided-portals/versions?g=1.19.4)![Separator](https://raw.githubusercontent.com/crystal-nest/mod-fancy-assets/main/separator.svg)[![1.19.2](https://raw.githubusercontent.com/crystal-nest/mod-fancy-assets/main/minecraft/1-19-2.svg "1.19.2")](https://modrinth.com/mod/server-sided-portals/versions?g=1.19.2)

![Loader](https://raw.githubusercontent.com/crystal-nest/mod-fancy-assets/main/loader/loader.svg "Loader")[![NeoForge](https://raw.githubusercontent.com/crystal-nest/mod-fancy-assets/main/loader/neoforge.svg "NeoForge")](https://modrinth.com/mod/server-sided-portals/versions?l=neoforge)![Separator](https://raw.githubusercontent.com/crystal-nest/mod-fancy-assets/main/separator.svg)[![Forge](https://raw.githubusercontent.com/crystal-nest/mod-fancy-assets/main/loader/forge.svg "Forge")](https://modrinth.com/mod/server-sided-portals/versions?l=forge)![Separator](https://raw.githubusercontent.com/crystal-nest/mod-fancy-assets/main/separator.svg)[![Fabric](https://raw.githubusercontent.com/crystal-nest/mod-fancy-assets/main/loader/fabric.svg "Fabric")](https://modrinth.com/mod/server-sided-portals/versions?l=fabric)

![Overlay](https://raw.githubusercontent.com/crystal-nest/mod-fancy-assets/main/side/server.svg)

![Issues](https://raw.githubusercontent.com/crystal-nest/mod-fancy-assets/main/github/issues.svg "Issues")[![GitHub](https://raw.githubusercontent.com/crystal-nest/mod-fancy-assets/main/github/github.svg "GitHub")](https://github.com/crystal-nest/server-sided-portals/issues)

---

## 📝 **Description**

This is a mod API that provides easily customizable and server-sided portals to any custom dimension.  
This mod is required server side only, and is thus compatible with any client, Vanilla included.  
This mod can be used as a dependency for another mod/datapack, or bundled in a modpack with a custom datapack or with mods that require it.

Check out the usage details below or on the [Wiki](https://github.com/Crystal-Nest/server-sided-portals/wiki)!

## ✨ **Features**

- 🔮 **Custom Portals**: Create portals with fully customizable frames linked to any dimension.
- 🧱 **Flexible Frame Design**: Define valid frame blocks using block tags — supports multiple block types!
- 🔥 **Custom Igniters**: Choose which items can light the portal using item tags — supports multiple items!
- 🖥️ **Server-Side Only**: No need to install the mod on clients — works entirely server-side.
- 🌍 **Cross-Dimension Support**: Add portals to *any* dimension, even ones added by other mods.
- ✅ **Fully Compatible**: Works seamlessly with both Vanilla and modded clients.
- 🧩 **Mod & Datapack Friendly**: Simple integration whether you're using a datapack or developing a mod.
- 📚 **Comprehensive Wiki**: Check out the [Wiki](https://github.com/Crystal-Nest/server-sided-portals/wiki) for guides, examples, and more features!

## 🚀 **Usage**

For detailed examples, check out the [Wiki](https://github.com/Crystal-Nest/server-sided-portals/wiki/Working-examples).  
There, you'll find step-by-step guides for creating custom dimensions, portal frames, igniters, and additional tweaks!

### 📦 Datapack

Making use of this mod with a datapack is easy! Just follow these simple steps:

1. **Set up a datapack**: Start by creating a datapack following [this Minecraft tutorial](https://minecraft.wiki/w/Tutorials/Creating_a_data_pack).
2. **Define a dimension Type**: Generate a custom dimension type with [this generator](https://misode.github.io/dimension-type/).
3. **Create your dimension**: Use [this generator](https://misode.github.io/dimension/) to set up your custom dimension.
4. **Specify portal frame blocks**: Create a block tag called `dimension_portal_frame`, replacing `dimension` with your dimension name. You can include multiple blocks or even other tags!
5. **(Optional) Choose portal igniters**: Optionally create an item tag named `dimension_portal_igniter`, replacing `dimension` with your dimension name, for items that can ignite the portal. You can also use multiple items or tags.
6. **Organize your files**: Make sure all JSON files from the above steps are under the same namespace.

That's it! Load your datapack alongside this mod, and your dimensions and portals are ready to use.  
You're free to add multiple dimensions, each with unique portal frames and igniters!

Since **v2.1.0**, you can further customize your dimensions by setting specific gamemodes for players entering them or defining custom entry points other than the Overworld.  
Check out the [Wiki](https://github.com/Crystal-Nest/server-sided-portals/wiki) for details.

### 🛠️ Mod

Integrating this API into your mod is straightforward:

- Follow the steps outlined in the Datapack section above.
- Instead of placing files in a datapack, place them under your mod's resource folder: `resources/data/mod_id/`.

If you prefer giving users the choice to enable or disable your datapack, consider using [Cobweb static datapack API](https://github.com/Crystal-Nest/cobweb/wiki/Common-API#static--dynamic-resource-packs).

Creating a mod (rather than a datapack) allows you to add extra functionality and enhance your custom dimensions further.

Additionally, this API provides several helpful utility methods. Explore the Javadoc for detailed documentation on these methods.

## 🔄 **Compatibilities**

| Mod                                                            | Loader |                                                         Compatibility                                                          |
|:---------------------------------------------------------------|:------:|:------------------------------------------------------------------------------------------------------------------------------:|
| [Crying Portals](https://modrinth.com/mod/crying-portals)      |  All   |                                                          Incompatible                                                          |
| [Immersive Portals](https://modrinth.com/mod/immersiveportals) |  All   |                                                          Incompatible                                                          |
| [BetterNether](https://modrinth.com/mod/betternether)          | Fabric |                                                           Compatible                                                           |
| [Very Many Players](https://modrinth.com/mod/vmp-fabric)       | Fabric |                                           Compatible with `use_async_portals=false`                                            |
| [Canary](https://modrinth.com/mod/canary)                      | Forge  | Compatible with [fast portals](https://github.com/AbdElAziz333/Canary/wiki/Configuration-File#mixinaipoifast_portals) disabled |

## 🔗 **Dependencies**

| Mod                                       | Loader | Requirement |
|:------------------------------------------|:------:|:-----------:|
| [Cobweb](https://modrinth.com/mod/cobweb) |  All   |  Required   |

## 📜 **License and right of use**

Feel free to use this mod for any modpack or video, just be sure to give credit and possibly link [here](https://github.com/crystal-nest/server-sided-portals#readme).  
This project is published under the [Crystal Nest Community License v1](https://github.com/crystal-nest/server-sided-portals/blob/master/LICENSE).

## ❤️ **Support us**

<a href="https://crystalnest.it"><img alt="Crystal Nest Website" src="https://raw.githubusercontent.com/crystal-nest/mod-fancy-assets/main/crystal-nest/pic512.png" width="14.286%"></a><a href="https://discord.gg/BP6EdBfAmt"><img alt="Discord" src="https://raw.githubusercontent.com/crystal-nest/mod-fancy-assets/main/discord/discord512.png" width="14.286%"></a><a href="https://www.patreon.com/crystalspider"><img alt="Patreon" src="https://raw.githubusercontent.com/crystal-nest/mod-fancy-assets/main/patreon/patreon512.png" width="14.286%"></a><a href="https://ko-fi.com/crystalspider"><img alt="Ko-fi" src="https://raw.githubusercontent.com/crystal-nest/mod-fancy-assets/main/kofi/kofi512.png" width="14.286%"></a><a href="https://github.com/Crystal-Nest"><img alt="Our other projects" src="https://raw.githubusercontent.com/crystal-nest/mod-fancy-assets/main/github/github512.png" width="14.286%"><a href="https://modrinth.com/organization/crystal-nest"><img alt="Modrinth" src="https://raw.githubusercontent.com/crystal-nest/mod-fancy-assets/main/modrinth/modrinth512.png" width="14.286%"></a><a href="https://www.curseforge.com/members/crystalspider/projects"><img alt="CurseForge" src="https://raw.githubusercontent.com/crystal-nest/mod-fancy-assets/main/curseforge/curseforge512.png" width="14.286%"></a>

[![Bisect Hosting](https://www.bisecthosting.com/partners/custom-banners/d559b544-474c-4109-b861-1b2e6ca6026a.webp "Bisect Hosting")](https://bisecthosting.com/crystalspider)
